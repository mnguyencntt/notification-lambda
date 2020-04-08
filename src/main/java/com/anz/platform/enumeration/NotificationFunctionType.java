package com.anz.platform.enumeration;

import java.util.Arrays;
import java.util.List;

public enum NotificationFunctionType {
  //
  SEND("", "Send new notification"),
  //
  UPDATE("", "Update notification"),
  //
  FIND("", "Find notification by Id"),
  //
  FINDALL("", "Find all notifications"),
  //
  DELETE("", "Delete notiification by Id");

  private String value;
  private String desc;

  NotificationFunctionType(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public static List<NotificationFunctionType> getAll() {
    return Arrays.asList(NotificationFunctionType.values());
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
