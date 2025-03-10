package vn.duke.finance_tracker.api.common.exception.finance;

import org.springframework.http.HttpStatus;
import vn.duke.finance_tracker.api.common.errorcode.ErrorCode;
import vn.duke.finance_tracker.api.common.exception.common.ApiException;

public class InsufficientFundsException extends ApiException {

    public InsufficientFundsException(String message) {
        super(ErrorCode.INSUFFICIENT_FUNDS, HttpStatus.BAD_REQUEST, message);
    }

    public InsufficientFundsException(double balance, double amount, String accountId) {
        super(
                ErrorCode.INSUFFICIENT_FUNDS,
                HttpStatus.BAD_REQUEST,
                String.format(
                        "Insufficient funds: account %s has balance %.2f but requires %.2f",
                        accountId, balance, amount
                )
        );
    }

}
