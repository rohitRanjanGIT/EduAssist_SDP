package spr.jfsd_sdp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class FinancialAid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Name of the financial aid program

    private String description;  // A description of the financial aid program

    private String eligibilityCriteria;  // Eligibility criteria for the financial aid

    private Double amount;  // Amount of financial aid

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationDeadline;  // Deadline for financial aid applications

    private String status;  // Status (e.g., Available, Closed)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;  // Date the financial aid was created

    // Auto-set createdDate before persisting to the database
    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDate.now();
    }
}
