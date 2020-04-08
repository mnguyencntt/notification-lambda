package com.anz.platform.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import com.amazonaws.services.lambda.runtime.Context;
import com.anz.platform.config.AppConfig;
import com.anz.platform.domain.ApiResponse;
import com.anz.platform.domain.DbInfo;
import com.anz.platform.domain.EmailInfo;
import com.anz.platform.domain.MessageInfo;
import com.anz.platform.domain.NotificationRequest;
import com.anz.platform.domain.NotificationResponse;
import com.anz.platform.domain.SmsInfo;
import com.anz.platform.exception.NotificationException;
import com.anz.platform.model.Notification;
import com.anz.platform.util.Constants;
import com.anz.platform.util.JsonUtils;
import com.anz.platform.util.ObjectUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class NotificationFunction {
  private AppConfig appConfig = new AppConfig();
  private DbInfo dbInfo = appConfig.getDbInfo();
  private SmsInfo smsInfo = appConfig.getSmsInfo();
  private EmailInfo emailInfo = appConfig.getEmailInfo();

  /*
   * sendNotification
   */
  public ApiResponse sendNotification(final NotificationRequest request, final Context context) {
    try {
      log.info("Request Data: {}", request);
      final NotificationService notificationService = new NotificationService(dbInfo);

      final String subject = String.format(Constants.SUBJECT_TEMPLATE, request.getEventStatus(), request.getOrderId());
      final String contentBody = String.format(Constants.CONTENTBODY_TEMPLATE, request.getEventStatus(), request.getOrderId());
      final MessageInfo messageInfo = new MessageInfo(subject, contentBody, request.getSmsNumber(), request.getSesEmail());
      final AtomicInteger amount = new AtomicInteger(0);
      // Send SMS
      if (ObjectUtils.isNotEmpty(request.getSmsNumber())) {
        SmsService smsService = new SmsService(smsInfo);
        smsService.sendSms(messageInfo);
        amount.getAndIncrement();
      }

      // Send Email
      if (ObjectUtils.isNotEmpty(request.getSesEmail())) {
        EmailService emailService = new EmailService(emailInfo);
        emailService.sendEmailSSL(messageInfo);
        amount.getAndIncrement();
      }

      final Notification notification = Notification.builder()
          .id(UUID.randomUUID().toString())
          .receiverUserId(request.getRecieverId())
          .subject(subject)
          .contentBody(contentBody)
          .notificationType(request.getNotificationType())
          .amount(String.valueOf(amount.get()))
          .status(Constants.STATUS_000)
          .message(Constants.NOTIFICATION_SEND_SUCCESS)
          .request(JsonUtils.toJson(request))
          .build();
      notification.persist();

      final Integer updatedCount = notificationService.persist(notification);
      if (updatedCount > 0) {
        log.info("Response Data: {}", notification);
        return ApiResponse.build(Constants.STATUS_000, NotificationResponse.buildResponse(notification, String.valueOf(amount)), Constants.NOTIFICATION_SEND_SUCCESS);
      } else {
        throw new NotificationException(Constants.NOTIFICATION_PERSIST_FAILED);
      }
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new NotificationException(e.getMessage());
    }
  }

  /*
   * findNotification
   */
  public ApiResponse findNotification(final NotificationRequest request, final Context context) {
    try {
      log.info("Request Data: {}", request);
      final NotificationService notificationService = new NotificationService(dbInfo);
      final Notification notification = notificationService.findById(request.getNotificationId(), Notification.class);
      log.info("Response Data: {}", notification);
      return ApiResponse.build(Constants.STATUS_000, notification, Constants.NOTIFICATION_FOUND);
    } catch (Exception e) {
      log.error(e.getMessage());
      return ApiResponse.build(Constants.STATUS_999, null, Constants.NOTIFICATION_NOT_FOUND);
    }
  }

  /*
   * findNotifications
   */
  public ApiResponse findNotifications(final NotificationRequest request, final Context context) {
    try {
      log.info("Request Data: {}", request);
      final NotificationService notificationService = new NotificationService(dbInfo);
      final List<Notification> notifications = notificationService.findAll(Notification.class);
      notifications.sort(Comparator.comparing(Notification::getUpdatedAt));
      log.info("Response Data: {}", notifications);
      return ApiResponse.build(Constants.STATUS_000, notifications, Constants.NOTIFICATION_FOUND);
    } catch (Exception e) {
      log.error(e.getMessage());
      return ApiResponse.build(Constants.STATUS_999, Collections.emptyList(), Constants.NOTIFICATION_NOT_FOUND);
    }
  }
}
