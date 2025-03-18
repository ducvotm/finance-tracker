package vn.duke.finance_tracker.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.duke.finance_tracker.api.entity.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDtoOut {
    private Long id;
    private BigDecimal amount;
    private String description;
    private LocalDateTime transactionDate;

    private Long categoryId;
    private String categoryName;

    private Long accountId;
    private String accountName;

    public static TransactionDtoOut from(Transaction transaction) {
        return TransactionDtoOut.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .transactionDate(transaction.getTransactionDate())
                .categoryId(transaction.getCategory().getId())
                .categoryName(transaction.getCategory().getName())
                .accountId(transaction.getAccount().getId())
                .accountName(transaction.getAccount().getName())
                .build();
    }

}
