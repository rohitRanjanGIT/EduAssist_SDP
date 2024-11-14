package spr.jfsd_sdp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spr.jfsd_sdp.Model.AdminUser;
import spr.jfsd_sdp.Model.StudentUser;
import spr.jfsd_sdp.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    // Admin login
    @PostMapping("/admin/login")
    public ResponseEntity<String> loginAdmin(@RequestBody AdminUser adminUser) {
        boolean isAuthenticated = authService.authenticateAdmin(adminUser);
        return isAuthenticated ? new ResponseEntity<>("Admin Login Successful", HttpStatus.OK) : new ResponseEntity<>("Invalid Admin Credentials", HttpStatus.UNAUTHORIZED);
    }

    // Student login
    @PostMapping("/student/login")
    public ResponseEntity<String> loginStudent(@RequestBody StudentUser studentUser) {
        boolean isAuthenticated = authService.authenticateStudent(studentUser);
        return isAuthenticated ? new ResponseEntity<>("Student Login Successful", HttpStatus.OK) : new ResponseEntity<>("Invalid Student Credentials", HttpStatus.UNAUTHORIZED);
    }

    // Register student
        @PostMapping("/student/register")
    public ResponseEntity<StudentUser> registerStudent(@RequestBody StudentUser studentUser) {
        return new ResponseEntity<>(authService.registerStudent(studentUser), HttpStatus.CREATED);
    }

    // Register admin
    @PostMapping("/admin/register")
    public ResponseEntity<AdminUser> registerAdmin(@RequestBody AdminUser adminUser) {
        return new ResponseEntity<>(authService.registerAdmin(adminUser), HttpStatus.CREATED);
    }
}
