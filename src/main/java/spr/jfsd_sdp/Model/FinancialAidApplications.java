package spr.jfsd_sdp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FinancialAidApplications {
    @Id
    private Long applicationId;

    private Integer studentId;

    private Integer scholarshipId;

    private boolean phase1; // 1

    private boolean phase2; // reject

    private boolean phase3; // accept

}