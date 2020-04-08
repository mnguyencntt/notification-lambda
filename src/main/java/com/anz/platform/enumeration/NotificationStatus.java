package com.anz.platform.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public enum NotificationStatus {
  //
  NEW(1, "New", ""),
  //
  INPROGRESS(2, "Inprogress", ""),
  //
  COMPLETED(3, "Completed", ""),
  //
  FAILED(4, "Failed", "");

  private Integer id;
  private String value;
  private String desc;

  NotificationStatus(Integer id, String value, String desc) {
    this.id = id;
    this.value = value;
    this.desc = desc;
  }

  public static List<NotificationStatus> getAll() {
    return Arrays.asList(NotificationStatus.values());
  }

  public static NotificationStatus getReactStatus(final int statusId) {
    Optional<NotificationStatus> findFirst = Stream.of(NotificationStatus.values()).filter(p -> p.getId().equals(statusId)).findFirst();
    return findFirst.isPresent() ? findFirst.get() : null;
  }

  public Integer getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
