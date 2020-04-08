package com.anz.platform.enumeration;

import static com.anz.platform.util.Constants.NOT_EMPTY;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.anz.platform.exception.NotificationException;
import com.anz.platform.util.ObjectUtils;

public enum FailedReason {
  //
  REQUEST_INVALID("REQUEST_INVALID", ""),
  //
  EMAIL_INVALID("EMAIL_INVALID", ""),
  //
  SMS_INVALID("SMS_INVALID", ""),
  //
  DB_CONNECTION("DB_CONNECTION", ""),
  //
  BACKEND_ERROR("BACKEND_ERROR", "");

  private String key;
  private String value;

  FailedReason(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public static List<FailedReason> getAll() {
    return Arrays.asList(FailedReason.values());
  }

  public static FailedReason getByKey(final String key) {
    ObjectUtils.notEmpty(key, String.format(NOT_EMPTY, "FailedReasonKey"));

    Optional<FailedReason> findFirst = Arrays.asList(FailedReason.values()).stream().filter(p -> p.getKey().equals(key)).findFirst();
    if (findFirst.isPresent())
      return findFirst.get();
    throw new NotificationException("Status '%s' is not defined.");
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
