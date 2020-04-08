package com.anz.platform.enumeration;

import java.util.Arrays;
import java.util.List;

public enum NotificationType {
  //
  SMS("", ""),
  //
  EMAIL("", ""),
  //
  SMS_EMAIL("", "");

  private String value;
  private String desc;

  NotificationType(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public static List<NotificationType> getAll() {
    return Arrays.asList(NotificationType.values());
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
