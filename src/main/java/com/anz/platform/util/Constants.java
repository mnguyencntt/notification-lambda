package com.anz.platform.util;

public final class Constants {
  public static final String STATUS_000 = "000";
  public static final String STATUS_101 = "101";
  public static final String STATUS_301 = "301";
  public static final String STATUS_999 = "999";

  public static final String PREFIX_REPORT_NAME = "anz_platform_report_";
  public static final String[] EMAIL_VARS = new String[] {"${reportDate}", "${password}", "${fileName}"};

  public static final int DIFF_1 = 1;
  public static final int DIFF_24 = 24;

  public static final String ZONEID_SINGAPORE = "Singapore";
  public static final String GMT = "GMT";
  public static final String DDMMMYYYY = "ddMMMyyyy";
  public static final String MMDDYYYY = "MMddyyyy";
  public static final String MMDDYYYY_HHMMSS = "MMddyyyyHHmmSS";
  public static final String DDMMYYYY_HHMMSS = "dd-MM-yyyy HH:mm:ss";
  public static final String DDMMYYYY_HHMMSS_Z = "dd-MM-yyyy HH:mm:ss Z";
  public static final String YYYYMMDD_HHMMSS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String DDMMYYYY_HHMMSS_SSS = "ddMMyyyyhhmmssSSS";

  public static final Character C_PIPE = '|';
  public static final Character C_COMMA = ',';
  public static final String EMPTY = "";
  public static final String DOT = ".";
  public static final String QUESTION = "?";
  public static final String COMMA = ",";
  public static final String EQUAL = "=";
  public static final String QUOTES = "\"";
  public static final String COLON = ":";
  public static final String SEMICOLON = ";";
  public static final String UNDERSCORE = "_";
  public static final String NEW_LINE_SEPARATOR = "\n";

  public static final String DOT_TXT = ".txt";
  public static final String DOT_CSV = ".csv";
  public static final String DOT_ZIP = ".zip";

  public static final String NOT_EMPTY = "%s cannot be EMPTY/NULL";

  public static final String UTF8 = "UTF-8";
  public static final String ERROR = "Error: ";
  public static final String TEXT_HTML = "text/html";
  public static final String RECIPIENTS = "Recipients";
  public static final String ATTACHMENT_PARTS = "AttachmentParts";

  public static final String SUBJECT_TEMPLATE = "[AnZ-Platform] %s with OrderId-%s";
  public static final String CONTENTBODY_TEMPLATE = "[AnZ-Platform] %s with OrderId-%s";

  public static final String SMS_SENT_SUCCESSFUL = "SMS sent successful!!!";
  public static final String EMAIL_SENT_SUCCESSFUL = "Email sent successful!!!";
  public static final String NOTIFICATION_FUNCTION_NOT_SUPPORT = "NotificationFunctionType '%s' does not support.";
  public static final String NOTIFICATION_PERSIST_SUCCESS = "Notification persisted success.";
  public static final String NOTIFICATION_PERSIST_FAILED = "Notification persisted fail.";
  public static final String NOTIFICATION_SEND_SUCCESS = "Notification sent success.";
  public static final String NOTIFICATION_SEND_FAILED = "Notification sent fail.";
  public static final String NOTIFICATION_FOUND = "Notification found.";
  public static final String NOTIFICATION_NOT_FOUND = "Notification not found.";
  public static final String INITIALIZE_CONNECTION = "Initialize connection to MySQL with driver.";
  public static final String SUCCESSFUL_CONNECTION = "Connected to MySQL database. Now try to execute query by QueryRunner.";

  Constants() {
    throw new UnsupportedOperationException();
  }
}
