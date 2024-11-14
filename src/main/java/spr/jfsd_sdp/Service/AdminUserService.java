package spr.jfsd_sdp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spr.jfsd_sdp.Model.AdminUser;
import spr.jfsd_sdp.Repository.AdminUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {

    private final AdminUserRepository adminUserRepository;

    @Autowired
    public AdminUserService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    // Create a new admin user
    public AdminUser createAdminUser(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    // Retrieve all admin users
    public List<AdminUser> getAllAdminUsers() {
        return adminUserRepository.findAll();
    }

    // Retrieve an admin user by username
    public Optional<AdminUser> getAdminUserByUsername(String username) {
        return adminUserRepository.findById(username);
    }

    // Update admin user password
    public AdminUser updateAdminUserPassword(String username, String newPassword) {
        Optional<AdminUser> adminUserOptional = adminUserRepository.findById(username);
        if (adminUserOptional.isPresent()) {
            AdminUser adminUser = adminUserOptional.get();
            adminUser.setPassword(newPassword);
            return adminUserRepository.save(adminUser);
        }
        return null;
    }

    // Delete an admin user by username
    public void deleteAdminUser(String username) {
        adminUserRepository.deleteById(username);
    }
}
