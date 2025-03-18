package vn.duke.finance_tracker.api.service;

import vn.duke.finance_tracker.api.dto.in.TransactionDtoIn;
import vn.duke.finance_tracker.api.dto.out.TransactionDtoOut;
import vn.duke.finance_tracker.api.entity.Transaction;

public interface TransactionService {

    TransactionDtoOut create(TransactionDtoIn transactionDtoIn);
    TransactionDtoOut update(Long id, TransactionDtoIn transactionDtoIn);
    TransactionDtoOut get(Long id);
    void delete(Long id);

}
