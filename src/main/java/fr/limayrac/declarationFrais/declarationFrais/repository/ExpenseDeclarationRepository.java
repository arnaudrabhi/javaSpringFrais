// BankDetailsRepository.java
package fr.limayrac.declarationFrais.declarationFrais.repository;

import fr.limayrac.declarationFrais.declarationFrais.model.BankDetails;
import fr.limayrac.declarationFrais.declarationFrais.model.ExpenseDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDeclarationRepository extends JpaRepository<ExpenseDeclaration, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}
