package vn.duke.finance_tracker.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.duke.finance_tracker.api.dto.in.TransactionDtoIn;
import vn.duke.finance_tracker.api.entity.Transaction;
import vn.duke.finance_tracker.api.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction create(TransactionDtoIn transactionDtoIn) {

        return null;
    }

    public Transaction update(Long id, TransactionDtoIn transactionDtoIn) {
        return null;
    }

    public Transaction get(Long id) {
        return null;
    }

    public void delete(Long id) {
    }
}
