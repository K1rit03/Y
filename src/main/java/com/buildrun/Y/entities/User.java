package com.buildrun.Y.entities;


import com.buildrun.Y.dto.LoginRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "tb_users")

public class User {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userId;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    @JoinTable(
            name = "tb_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public boolean isLoginRequest(LoginRequest loginRequest, PasswordEncoder passwordEncoder){
        return passwordEncoder.matches(loginRequest.password(), this.password);


    }
    
}
