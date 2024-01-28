package fr.limayrac.declarationFrais.declarationFrais;

import fr.limayrac.declarationFrais.declarationFrais.model.Role;
import fr.limayrac.declarationFrais.declarationFrais.model.User;
import fr.limayrac.declarationFrais.declarationFrais.repository.RoleRepository;
import fr.limayrac.declarationFrais.declarationFrais.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Arrays;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public void onApplicationEvent(@NotNull ContextRefreshedEvent contextRefreshedEvent) {
        initializeRoles();
        initializeUsers();
    }

    private void initializeRoles() {
        createRoleIfNotExists("ADMIN");
        createRoleIfNotExists("FORMATEUR");
    }

    private void createRoleIfNotExists(String roleName) {
        Role existingRole = roleRepository.findByName(roleName);
        if (existingRole == null) {
            Role newRole = new Role();
            newRole.setName(roleName);
            roleRepository.save(newRole);
        }
    }

    private void initializeUsers() {
        createUserIfNotExists("admin@example.com", "admin", "ADMIN", "Admin", "User");
        createUserIfNotExists("formateur@example.com", "formateur", "FORMATEUR", "Formateur", "User");
    }

    private void createUserIfNotExists(String email, String password, String roleName, String firstName, String lastName) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser == null) {
            User newUser = new User();
            newUser.setCivility("M.");
            newUser.setEmail(email);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setRoles(Arrays.asList(roleRepository.findByName(roleName)));
            newUser.setCreated_at(Instant.now());
            newUser.setUpdated_at(Instant.now());
            userRepository.save(newUser);
        }
    }
}
