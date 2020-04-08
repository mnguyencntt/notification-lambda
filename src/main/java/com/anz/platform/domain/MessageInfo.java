package com.anz.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInfo {
  private String subject;
  private String contentBody;
  private String smsNumber;
  private String sesEmail;
}
