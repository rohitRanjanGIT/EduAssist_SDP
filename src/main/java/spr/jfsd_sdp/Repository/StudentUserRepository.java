package spr.jfsd_sdp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spr.jfsd_sdp.Model.StudentUser;


public interface StudentUserRepository extends JpaRepository<StudentUser, Long> {
    // You can define custom query methods if needed, e.g., findByEmail
    StudentUser findByEmail(String email);
}
