package com.anz.platform.config;

import com.anz.platform.domain.DbInfo;
import com.anz.platform.domain.EmailInfo;
import com.anz.platform.domain.SmsInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppConfigMock {
  public DbInfo getDbInfo() {
    // final String dbEndpoint = "jdbc:mysql://anz-platform-instance2.***.ap-southeast-2.rds.amazonaws.com:3306/users";
    // final String dbUsername = "***";
    // final String dbPassword = "***";

    final String dbEndpoint = "jdbc:h2:mem:;INIT=runscript from 'classpath:file/users.sql'";
    final String dbUsername = "sa";
    final String dbPassword = "";
    final String dbSqlDriver = "org.h2.Driver";

    DbInfo dbInfo = new DbInfo(dbEndpoint, dbUsername, dbPassword, dbSqlDriver);
    log.info(dbInfo.toString());
    return dbInfo;
  }


  public SmsInfo getSmsInfo() {
    // https://www.twilio.com/console
    final String smsAccountSid = "***";
    final String smsAuthToken = "***";
    final String smsTrialNumber = "***";
    SmsInfo smsInfo = new SmsInfo(smsAccountSid, smsAuthToken, smsTrialNumber);

    log.info(smsInfo.toString());
    return smsInfo;
  }

  public EmailInfo getEmailInfo() {
    final String sesUsername = "***";
    final String sesPassword = "***";
    EmailInfo emailInfo = new EmailInfo(sesUsername, sesPassword);
    log.info(emailInfo.toString());
    return emailInfo;
  }
}
