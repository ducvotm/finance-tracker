package vn.duke.finance_tracker.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ai_insights")
public class AiInsight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private LocalDateTime createdAt;

    private boolean isRead;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
