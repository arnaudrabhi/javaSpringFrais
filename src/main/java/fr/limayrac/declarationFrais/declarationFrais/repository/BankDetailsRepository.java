// BankDetailsRepository.java
package fr.limayrac.declarationFrais.declarationFrais.repository;

import fr.limayrac.declarationFrais.declarationFrais.model.BankDetails;
import fr.limayrac.declarationFrais.declarationFrais.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
    List<BankDetails> getByUser(User user);
}
