package fr.limayrac.declarationFrais.declarationFrais.repository;

import fr.limayrac.declarationFrais.declarationFrais.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User WHERE u.email = ?1")
    public User findByEmail(String email);
}
