package fr.limayrac.declarationFrais.declarationFrais.security;

import fr.limayrac.declarationFrais.declarationFrais.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        return authorities;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // Assuming getUsername returns the user's username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Replace with your logic for account expiration
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Replace with your logic for account locking
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Replace with your logic for credentials expiration
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled(); // Assuming isEnabled returns the user's enabled status
    }
}
