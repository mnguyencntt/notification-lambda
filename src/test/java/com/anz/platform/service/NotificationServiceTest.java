package com.anz.platform.service;

import java.util.List;
import java.util.UUID;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import com.anz.platform.config.AppConfigMock;
import com.anz.platform.model.Notification;

public class NotificationServiceTest {
  @Ignore
  @Test
  public void testNotification() {
    final NotificationService notificationService = new NotificationService(new AppConfigMock().getDbInfo());

    final Notification notification = Notification.builder().id(UUID.randomUUID().toString()).receiverUserId("UIB12345").subject("Notification OrderId OID12345")
        .contentBody("Minh Nguyen Testing Content Body").notificationType("EMAIL").amount("1").build();
    notification.setStatus("status");
    notification.setMessage("message");
    notification.setRequest("request");
    notification.persist();

    System.out.println(notificationService.persist(notification));
    List<Notification> notifications = notificationService.findAll(Notification.class);
    System.out.println(notifications.size());
    System.out.println(notifications);
  }
}
