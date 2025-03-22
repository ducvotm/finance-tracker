package vn.duke.finance_tracker.api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.duke.finance_tracker.api.dto.in.TransactionDtoIn;
import vn.duke.finance_tracker.api.dto.out.TransactionDtoOut;
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

    @Override
    public TransactionDtoOut create(TransactionDtoIn transactionDtoIn) {

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

        return TransactionDtoOut.from(transaction);
    }

    @Override
    public TransactionDtoOut update(Long id, TransactionDtoIn transactionDtoIn) {

        Transaction existedTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        Account account = accountRepository.findById(transactionDtoIn.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        Category category = categoryRepository.findById(transactionDtoIn.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        Transaction updatedTransaction = existedTransaction.toBuilder()
                .id(existedTransaction.getId())
                .amount(transactionDtoIn.getAmount())
                .description(transactionDtoIn.getDescription())
                .transactionDate(transactionDtoIn.getTransactionDate())
                .category(category)
                .account(account)
                .build();

        transactionRepository.save(updatedTransaction);

        return TransactionDtoOut.from(updatedTransaction);
    }

    @Override
    public TransactionDtoOut get(Long id) {
        Transaction transaction = transactionRepository.findById(id)

                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        return TransactionDtoOut.from(transaction);
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        transactionRepository.delete(transaction);

        System.out.println("Transaction with ID: " + id + " is deleted");

    }

    public void validateCategoryAndAccount(Category category, Account account) {

    }
}
