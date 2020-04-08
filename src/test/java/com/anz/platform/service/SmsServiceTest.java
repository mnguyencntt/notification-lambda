package com.anz.platform.service;

import org.junit.Ignore;
import org.junit.Test;
import com.anz.platform.config.AppConfigMock;
import com.anz.platform.domain.MessageInfo;

public class SmsServiceTest {
  @Ignore
  @Test
  public void testSendSms() {
    final String subject = String.format("[AnZ-Platform] %s with OrderId-%s", "ORDER_CREATED", "OI12345");
    final String contentBody = String.format("[AnZ-Platform] %s with OrderId-%s", "ORDER_CREATED", "OI12345");
    final MessageInfo messageInfo = new MessageInfo(subject, contentBody, "+6593767011", "m.nguyencntt7891@gmail.com");

    SmsService smsService = new SmsService(new AppConfigMock().getSmsInfo());
    System.out.println(smsService.sendSms(messageInfo));
  }
}
