package spr.jfsd_sdp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class StudentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment for ID
    private Long id;

    private String name;

    private String email;

    private String phone;

    private  String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

}
