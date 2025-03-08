package vn.duke.finance_tracker.api.common.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.duke.finance_tracker.api.common.errorcode.ErrorCode;
import vn.duke.finance_tracker.api.common.response.ApiResponse;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        return  responseEntity(e.getErrorCode(), e.getHttpStatus(), e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String supportedMethods = ex.getSupportedMethods() == null ? null : String.join(",", ex.getSupportedMethods());

        String msg = String.format("Method not supported: %s, only supported: %s", ex.getMethod(), supportedMethods);

        return responseEntity(ErrorCode.METHOD_NOT_ALLOWED, status, msg);
    }

    private ResponseEntity<Object> responseEntity(Integer errorCode, HttpStatusCode statusCode, String msg) {
        return new ResponseEntity<> (
                ApiResponse.builder().errorCode(errorCode).httpStatusCode(statusCode.value()).message(msg).build(),
                statusCode);
    }

}
