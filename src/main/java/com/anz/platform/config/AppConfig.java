package com.anz.platform.config;

import com.anz.platform.domain.DbInfo;
import com.anz.platform.domain.EmailInfo;
import com.anz.platform.domain.SmsInfo;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class AppConfig {
  private DbInfo dbInfo;
  private SmsInfo smsInfo;
  private EmailInfo emailInfo;

  public DbInfo getDbInfo() {
    String dbEndpoint = System.getenv("db_endpoint");
    String dbUsername = System.getenv("db_username");
    String dbPassword = System.getenv("db_password");
    String dbSqlDriver = System.getenv("db_sqlDriver"); // com.mysql.cj.jdbc.Driver - com.mysql.jdbc.Driver
    dbInfo = new DbInfo(dbEndpoint, dbUsername, dbPassword, dbSqlDriver);
    log.info(dbInfo.toString());
    return dbInfo;
  }

  public SmsInfo getSmsInfo() {
    String smsAccountSid = System.getenv("sms_account_sid");
    String smsAuthToken = System.getenv("sms_auth_token");
    String smsTrialNumber = System.getenv("sms_trial_number");
    smsInfo = new SmsInfo(smsAccountSid, smsAuthToken, smsTrialNumber);
    log.info(smsInfo.toString());
    return smsInfo;
  }

  public EmailInfo getEmailInfo() {
    String emailUsername = System.getenv("email_username");
    String emailPassword = System.getenv("email_password");
    emailInfo = new EmailInfo(emailUsername, emailPassword);
    log.info(emailInfo.toString());
    return emailInfo;
  }
}
