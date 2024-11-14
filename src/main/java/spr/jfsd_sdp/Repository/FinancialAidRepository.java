package spr.jfsd_sdp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spr.jfsd_sdp.Model.FinancialAid;

import java.util.List;

public interface FinancialAidRepository extends JpaRepository<FinancialAid, Long> {
    // Custom query method to find financial aids by status
    List<FinancialAid> findByStatus(String status);
}
