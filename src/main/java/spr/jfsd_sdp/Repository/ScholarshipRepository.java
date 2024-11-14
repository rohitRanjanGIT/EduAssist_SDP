package spr.jfsd_sdp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spr.jfsd_sdp.Model.Scholarship;

import java.util.List;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
    // Custom query method to find scholarships by status
    List<Scholarship> findByStatus(String status);

    // Custom query to find scholarships by type
    List<Scholarship> findByType(String type);
}
