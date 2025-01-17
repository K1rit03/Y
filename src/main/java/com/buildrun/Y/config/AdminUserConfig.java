package com.buildrun.Y.config;

import com.buildrun.Y.entities.Role;
import com.buildrun.Y.entities.User;
import com.buildrun.Y.repositories.RoleRepository;
import com.buildrun.Y.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@AllArgsConstructor
@Configuration
public class AdminUserConfig implements CommandLineRunner {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("Admin user already exists");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(bCryptPasswordEncoder.encode("123"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);

                }

        );
    }
}
