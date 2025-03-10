package vn.duke.finance_tracker.common.exception.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiException extends RuntimeException {
    private Integer errorCode;
    private HttpStatus httpStatus;

    public ApiException(Integer errorCode, HttpStatus httpStatus, String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public ApiException(String message) {
        this(500, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
