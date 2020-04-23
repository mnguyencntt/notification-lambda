package com.anz.platform.domain;

import java.util.Map;
import com.anz.platform.enumeration.NotificationFunctionType;
import com.anz.platform.enumeration.NotificationType;
import com.anz.platform.util.Constants;
import com.anz.platform.util.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
  // Query
  private String notificationId;

  // Sender
  private String senderId;
  private String orderId;
  private String deliveryId;
  private String eventStatus; // ORDER_CREATED - DELIVERY_CREATED - DELIVERY_COMPLETED

  // Reciever
  private String recieverId;
  private String smsNumber;
  private String sesEmail;

  // Function-Type
  private String username;
  private NotificationFunctionType functionType; // SEND - UPDATE - FINDID - FINDALL - DELETE
  private Map<String, String> additionalFields;

  public String getNotificationType() {
    if (ObjectUtils.isNotEmpty(this.getSesEmail()) && ObjectUtils.isNotEmpty(this.getSmsNumber())) {
      return NotificationType.SMS_EMAIL.name();
    } else if (ObjectUtils.isNotEmpty(this.getSmsNumber())) {
      return NotificationType.SMS.name();
    } else if (ObjectUtils.isNotEmpty(this.getSesEmail())) {
      return NotificationType.EMAIL.name();
    } else {
      return Constants.EMPTY;
    }
  }
}
