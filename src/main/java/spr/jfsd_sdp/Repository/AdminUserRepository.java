package spr.jfsd_sdp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spr.jfsd_sdp.Model.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, String> {

    AdminUser findByUsername(String username);

}
