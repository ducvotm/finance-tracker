package vn.duke.finance_tracker.api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.duke.finance_tracker.api.dto.in.TransactionDtoIn;
import vn.duke.finance_tracker.api.entity.Account;
import vn.duke.finance_tracker.api.entity.Category;
import vn.duke.finance_tracker.api.entity.Transaction;
import vn.duke.finance_tracker.api.repository.AccountRepository;
import vn.duke.finance_tracker.api.repository.CategoryRepository;
import vn.duke.finance_tracker.api.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
    }

    public Transaction create(TransactionDtoIn transactionDtoIn) {

        Account account = accountRepository.findById(transactionDtoIn.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        Category category = categoryRepository.findById(transactionDtoIn.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        Transaction transaction = transactionRepository.save(Transaction.builder()
                .account(account)
                .category(category)
                .amount(transactionDtoIn.getAmount())
                .description(transactionDtoIn.getDescription())
                .transactionDate(transactionDtoIn.getTransactionDate())
                .build()
        );

        return transaction;
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
