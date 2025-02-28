package vn.duke.finance_tracker.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    @Id
    private long id;

    private int amount;
    private String category;
    private LocalDateTime occured;
}
