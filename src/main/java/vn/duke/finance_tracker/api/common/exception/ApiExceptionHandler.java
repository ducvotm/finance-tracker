package vn.duke.finance_tracker.api.common.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.duke.finance_tracker.api.common.errorcode.ErrorCode;
import vn.duke.finance_tracker.api.common.exception.common.ApiException;
import vn.duke.finance_tracker.api.common.response.ApiResponse;

import java.util.stream.Collectors;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        return  responseEntity(e.getErrorCode(), e.getHttpStatus(), e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        String fieldErrors = ex.getFieldErrors().stream()
                .map(fieldError -> String.format("%s:%s", fieldError.getObjectName(), fieldError.getField()))
                .collect(Collectors.joining(","));

        String globalObjectErrors = ex.getGlobalErrors().stream()
                .map(ObjectError::getObjectName)
                .collect(Collectors.joining(","));

        String message = String.format("Validation failed: %s, global errors: %s", fieldErrors, globalObjectErrors);

        return responseEntity(ErrorCode.BAD_REQUEST, HttpStatus.BAD_REQUEST, message);
    }
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        String msg = String.format("Missing parameter: %s", ex.getParameterName());

        return responseEntity(ErrorCode.BAD_REQUEST, HttpStatus.BAD_REQUEST, msg);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        return responseEntity(ErrorCode.BAD_REQUEST, HttpStatus.BAD_REQUEST,
                "Invalid request format: " + ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleUnknownException(Exception e) {

        e.printStackTrace();

        return responseEntity(ErrorCode.INTERNAL_ERR, HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred. Please contact support.");
    }

    private ResponseEntity<Object> responseEntity(Integer errorCode, HttpStatusCode statusCode, String msg) {
        return new ResponseEntity<> (
                ApiResponse.builder()
                        .errorCode(errorCode)
                        .httpStatusCode(statusCode.value())
                        .message(msg)
                        .build(),
                statusCode);
    }

}
