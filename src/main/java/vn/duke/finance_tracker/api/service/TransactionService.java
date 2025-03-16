package vn.duke.finance_tracker.api.service;

import vn.duke.finance_tracker.api.dto.in.TransactionDtoIn;
import vn.duke.finance_tracker.api.entity.Transaction;

public interface TransactionService {

    Transaction create(TransactionDtoIn transactionDtoIn);
    Transaction update(Long id, TransactionDtoIn transactionDtoIn);
    Transaction get(Long id);
    void delete(Long id);

}
