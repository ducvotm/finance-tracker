package vn.duke.finance_tracker.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Statement {

    @Id
    private Long id;

    private int income;
    private int expense;
    private LocalDateTime start;
    private LocalDateTime end;
}
