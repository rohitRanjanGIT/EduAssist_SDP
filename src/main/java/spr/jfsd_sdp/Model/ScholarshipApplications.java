package spr.jfsd_sdp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ScholarshipApplications {
    @Id
    private Long applicationId;

    private Integer studentId;

    private Integer scholarshipId;

    private boolean phase1;

    private boolean phase2;

    private boolean phase3;

}
