package vn.duke.finance_tracker.common.errorcode;

public class ErrorCode {

    public static final Integer SUCCESS = 0;
    public static final Integer BAD_REQUEST = 400;
    public static final Integer UNAUTHORIZED = 401;
    public static final Integer FORBIDDEN = 403;
    public static final Integer NOT_FOUND = 404;
    public static final Integer METHOD_NOT_ALLOWED = 405;
    public static final Integer INTERNAL_ERR = 500;

    public static final Integer INSUFFICIENT_FUNDS = 1001;
    public static final Integer INVALID_TRANSACTION = 1002;
    public static final Integer CATEGORY_NOT_FOUND = 1003;

    public static final Integer USER_NOT_FOUND = 2001;
    public static final Integer AUTHENTICATION_FAILED = 2002;

}