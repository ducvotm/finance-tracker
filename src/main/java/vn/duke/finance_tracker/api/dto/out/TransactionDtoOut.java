package vn.duke.finance_tracker.api.dto.out;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDtoOut {
    private Long id;
    private BigDecimal amount;
    private String description;
    private LocalDateTime transactionDate;

    private Long categoryId;
    private String categoryName;

    private Long accountId;
    private String accountName;



}
