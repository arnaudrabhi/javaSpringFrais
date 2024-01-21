// BankDetailsRepository.java
package fr.limayrac.declarationFrais.declarationFrais.repository;

import fr.limayrac.declarationFrais.declarationFrais.model.TransportExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportExpenseRepository extends JpaRepository<TransportExpense, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}
