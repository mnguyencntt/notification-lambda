package com.anz.platform.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.anz.platform.base.BaseTest;
import com.anz.platform.config.AppConfig;
import com.anz.platform.config.AppConfigMock;
import com.anz.platform.domain.ApiResponse;
import com.anz.platform.domain.NotificationRequest;
import com.anz.platform.util.JsonUtils;

public class SendNotificationFunctionTest extends BaseTest {
  private AppConfigMock appConfigMock = new AppConfigMock();

  @Disabled
  @Test
  public void testNotification() {
    NotificationFunction notificationFunction = new NotificationFunction();
    AppConfig appConfig = new AppConfig();
    notificationFunction.setAppConfig(appConfig);
    notificationFunction.setDbInfo(appConfigMock.getDbInfo());
    notificationFunction.setSmsInfo(appConfigMock.getSmsInfo());
    notificationFunction.setEmailInfo(appConfigMock.getEmailInfo());

    String notificationRequestJson = "{\n" + 
        "  \"senderId\": \"UIB12345\",\n" + 
        "  \"orderId\": \"OI12345\",\n" + 
        "  \"deliveryId\": \"DI12345\",\n" + 
        "  \"eventStatus\": \"ORDER_CREATED\",\n" + 
        "  \"recieverId\": \"UIS12345\",\n" + 
        "  \"smsNumber\": \"\",\n" +  // +6593767011
        "  \"sesEmail\": \"m.nguyencntt7891@gmail.com\",\n" + 
        "  \"functionType\": \"SEND\"\n" + 
        "}";
    final NotificationRequest notificationRequest = JsonUtils.toObject(notificationRequestJson, NotificationRequest.class);
    ApiResponse sendNotification = notificationFunction.sendNotification(notificationRequest, createContext());
    System.out.println(sendNotification);
  }
}
