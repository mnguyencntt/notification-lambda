package com.anz.platform.service;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import com.anz.platform.base.BaseTest;
import com.anz.platform.config.AppConfig;
import com.anz.platform.config.AppConfigMock;
import com.anz.platform.domain.ApiResponse;
import com.anz.platform.domain.NotificationRequest;

public class FindNotificationsFunctionTest extends BaseTest {
  private AppConfigMock appConfigMock = new AppConfigMock();

  @Ignore
  @Test
  public void testNotification() {
    NotificationFunction notificationFunction = new NotificationFunction();
    AppConfig appConfig = new AppConfig();
    notificationFunction.setAppConfig(appConfig);
    notificationFunction.setDbInfo(appConfigMock.getDbInfo());

    ApiResponse sendNotification = notificationFunction.findNotifications(new NotificationRequest(), createContext());
    System.out.println(sendNotification);
  }
}
