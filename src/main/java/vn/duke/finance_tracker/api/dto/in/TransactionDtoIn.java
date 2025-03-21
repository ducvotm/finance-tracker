package vn.duke.finance_tracker.api.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TransactionDtoIn {

    @NotNull
    private BigDecimal amount;

    private String description;

    @NotNull
    private LocalDateTime transactionDate;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long accountId;


}

