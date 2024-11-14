package spr.jfsd_sdp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AdminUser {

    @Id
    private String username;

    private String password;

}