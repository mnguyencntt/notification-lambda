package com.anz.platform.service;

import static com.anz.platform.util.Constants.SMS_SENT_SUCCESSFUL;
import com.anz.platform.domain.MessageInfo;
import com.anz.platform.domain.SmsInfo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class SmsService {
  private SmsInfo smsInfo;

  public SmsService(final SmsInfo smsInfo) {
    this.smsInfo = smsInfo;
  }

  public String sendSms(final MessageInfo messageInfo) {
    try {
      Twilio.init(smsInfo.getAccountSid(), smsInfo.getAuthToken());
      PhoneNumber to = new PhoneNumber(messageInfo.getSmsNumber());
      PhoneNumber from = new PhoneNumber(smsInfo.getTrialNumber());
      Message message = Message.creator(to, from, messageInfo.getContentBody()).create();
      log.info(SMS_SENT_SUCCESSFUL);
      return message.getSid();
    } catch (com.twilio.exception.ApiException e) {
      log.info(e.getMessage());
      return null;
    }
  }
}
