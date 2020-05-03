package com.anz.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.anz.platform.base.BaseTest;
import com.anz.platform.domain.ApiResponse;
import com.anz.platform.domain.NotificationRequest;
import com.anz.platform.enumeration.NotificationFunctionType;
import com.anz.platform.util.JsonUtils;

@Disabled
public class NotificationHandlerTest extends BaseTest {
  private final NotificationHandler userHandler = new NotificationHandler();

  private final String jsonRequesst = "";

  @Test
  public void testFindAllUsers() {
    final NotificationRequest request = JsonUtils.toObject(jsonRequesst, NotificationRequest.class);
    request.setFunctionType(NotificationFunctionType.FINDALL);

    ApiResponse handleRequest = userHandler.handleRequest(request, createContext());
    System.out.println(handleRequest.toString());
    assertEquals("000", handleRequest.getStatus());
  }
}
