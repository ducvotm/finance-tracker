package vn.duke.finance_tracker.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Jar {

    @Id
    private int id;

    private String name;

    @Column(name = "target_amount")
    private int targetAmount;

    @Column(name = "actualAmount")
    private int actualAmount;
}
