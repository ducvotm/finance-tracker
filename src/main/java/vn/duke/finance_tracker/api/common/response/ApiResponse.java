package vn.duke.finance_tracker.api.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import vn.duke.finance_tracker.api.common.errorcode.ErrorCode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private Integer errorCode;
    private Integer httpStatusCode;
    private String message;
    private T object;

    public static <T> ApiResponse<T> success(T object) {
        return ApiResponse.<T>builder().errorCode(ErrorCode.SUCCESS).httpStatusCode(HttpStatus.OK.value()).object(object)
                .build();
    }

    public static <T> ApiResponse<T> error(Integer errorCode, HttpStatus httpStatus, String message) {
        return ApiResponse.<T>builder().errorCode(errorCode).httpStatusCode(httpStatus.value()).message(message)
                .build();
    }
}


