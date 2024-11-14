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
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String eligibilityCriteria;

    private Double amount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationDeadline;

    private String status;

    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    // Auto-set createdDate before persisting to the database
    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDate.now();
    }
}
