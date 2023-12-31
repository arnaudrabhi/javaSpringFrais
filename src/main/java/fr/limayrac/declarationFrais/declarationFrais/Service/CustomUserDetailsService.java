package fr.limayrac.declarationFrais.declarationFrais.Service;

import fr.limayrac.declarationFrais.declarationFrais.Entities.User;
import fr.limayrac.declarationFrais.declarationFrais.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
        return new CustomUserDetails(user);
    }
}
