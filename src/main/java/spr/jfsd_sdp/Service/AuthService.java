package spr.jfsd_sdp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spr.jfsd_sdp.Model.AdminUser;
import spr.jfsd_sdp.Model.StudentUser;
import spr.jfsd_sdp.Repository.AdminUserRepository;
import spr.jfsd_sdp.Repository.StudentUserRepository;

@Service
public class AuthService {

    private final AdminUserRepository adminUserRepository;
    private final StudentUserRepository studentUserRepository;

    @Autowired
    public AuthService(AdminUserRepository adminUserRepository, StudentUserRepository studentUserRepository) {
        this.adminUserRepository = adminUserRepository;
        this.studentUserRepository = studentUserRepository;
    }

    // Authenticate admin
    public boolean authenticateAdmin(AdminUser adminUser) {
        AdminUser foundAdmin = adminUserRepository.findByUsername(adminUser.getUsername());
        return foundAdmin != null && foundAdmin.getPassword().equals(adminUser.getPassword());
    }

    // Authenticate student
    public boolean authenticateStudent(StudentUser studentUser) {
        StudentUser foundStudent = studentUserRepository.findByEmail(studentUser.getEmail());
        return foundStudent != null && foundStudent.getPassword().equals(studentUser.getPassword());
    }

    // Register student
    public StudentUser registerStudent(StudentUser studentUser) {
        return studentUserRepository.save(studentUser);
    }

    // Register admin
    public AdminUser registerAdmin(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }
}
