// BankDetailsRepository.java
package fr.limayrac.declarationFrais.declarationFrais.repository;

import fr.limayrac.declarationFrais.declarationFrais.model.BankDetails;
import fr.limayrac.declarationFrais.declarationFrais.model.ExpenseDeclaration;
import fr.limayrac.declarationFrais.declarationFrais.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDeclarationRepository extends JpaRepository<ExpenseDeclaration, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire

    ExpenseDeclaration findByUserId(Long userId);

    List<ExpenseDeclaration> findByUser(User user);

}
