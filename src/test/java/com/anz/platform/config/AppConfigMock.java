package com.anz.platform.config;

import com.anz.platform.domain.DbInfo;
import com.anz.platform.domain.EmailInfo;
import com.anz.platform.domain.SmsInfo;
import com.anz.platform.util.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppConfigMock {
  public DbInfo getDbInfo() {
    final String dbEndpoint = "jdbc:mysql://anz-platform-instance2.***.ap-southeast-2.rds.amazonaws.com:3306/notification";
    final String dbUsername = "***";
    final String dbPassword = "***";
    DbInfo dbInfo = new DbInfo(dbEndpoint, dbUsername, dbPassword, Constants.EMPTY);
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
