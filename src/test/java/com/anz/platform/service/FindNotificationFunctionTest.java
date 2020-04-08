package com.anz.platform.service;

import org.junit.Ignore;
import org.junit.Test;
import com.anz.platform.base.BaseTest;
import com.anz.platform.config.AppConfig;
import com.anz.platform.config.AppConfigMock;
import com.anz.platform.domain.ApiResponse;
import com.anz.platform.domain.NotificationRequest;
import com.anz.platform.util.JsonUtils;

public class FindNotificationFunctionTest extends BaseTest {
  private AppConfigMock appConfigMock = new AppConfigMock();

  @Ignore
  @Test
  public void testNotification() {
    NotificationFunction notificationFunction = new NotificationFunction();
    AppConfig appConfig = new AppConfig();
    notificationFunction.setAppConfig(appConfig);
    notificationFunction.setDbInfo(appConfigMock.getDbInfo());

    String notificationRequestJson = "{\"notificationId\": \"317ea225-f03c-4f8e-afdb-75ed3f65aa87\"}";
    final NotificationRequest notificationRequest = JsonUtils.toObject(notificationRequestJson, NotificationRequest.class);
    ApiResponse sendNotification = notificationFunction.findNotification(notificationRequest, createContext());
    System.out.println(sendNotification);
  }
}
