package com.anz.platform;

import static com.anz.platform.util.Constants.NOTIFICATION_FUNCTION_NOT_SUPPORT;
import static com.anz.platform.util.Constants.STATUS_101;
import static com.anz.platform.util.Constants.STATUS_999;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.anz.platform.domain.ApiResponse;
import com.anz.platform.domain.NotificationRequest;
import com.anz.platform.enumeration.NotificationFunctionType;
import com.anz.platform.exception.InvalidRequestException;
import com.anz.platform.service.NotificationFunction;
import com.anz.platform.util.Constants;
import com.anz.platform.util.ObjectUtils;
import lombok.Setter;

@Setter
public class NotificationHandler implements RequestHandler<NotificationRequest, ApiResponse> {
  public ApiResponse handleRequest(final NotificationRequest request, final Context context) {
    try {
      if (ObjectUtils.isEmpty(request.getFunctionType())) {
        throw new InvalidRequestException(String.format(Constants.NOT_EMPTY, "functionType"));
      }

      final NotificationFunction function = new NotificationFunction();
      if (NotificationFunctionType.SEND.equals(request.getFunctionType())) {
        return function.sendNotification(request, context);
      } else if (NotificationFunctionType.FIND.equals(request.getFunctionType())) {
        return function.findNotification(request, context);
      } else if (NotificationFunctionType.FINDALL.equals(request.getFunctionType())) {
        return function.findNotifications(request, context);
      } else {
        throw new InvalidRequestException(String.format(NOTIFICATION_FUNCTION_NOT_SUPPORT, request.getFunctionType()));
      }
    } catch (InvalidRequestException e) {
      return ApiResponse.build(STATUS_101, null, e.getMessage());
    } catch (Exception e) {
      return ApiResponse.build(STATUS_999, null, e.getMessage());
    }
  }
}
