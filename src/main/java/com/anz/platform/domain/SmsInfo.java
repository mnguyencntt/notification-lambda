package com.anz.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsInfo {
  private String accountSid;
  private String authToken;
  private String trialNumber;
}
