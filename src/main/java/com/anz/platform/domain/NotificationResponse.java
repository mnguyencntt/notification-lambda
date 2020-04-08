package com.anz.platform.domain;

import com.anz.platform.model.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
  private String buyerId;
  private String sellerId;
  private String receiverId;
  private String notificationId;
  private String notificationType;
  private String amount;

  public static NotificationResponse buildResponse(final Notification notification, final String amount) {
    return NotificationResponse.builder().receiverId(notification.getReceiverUserId()).notificationId(notification.getId()).notificationType(notification.getNotificationType()).amount(amount).build();
  }
}
