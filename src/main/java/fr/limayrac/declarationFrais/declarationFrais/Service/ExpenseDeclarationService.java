package fr.limayrac.declarationFrais.declarationFrais.Service;

import fr.limayrac.declarationFrais.declarationFrais.model.ExpenseDeclaration;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ExpenseDeclarationService {


    public ExpenseDeclaration startNewDeclaration() {

        ExpenseDeclaration expenseDeclaration = new ExpenseDeclaration();
        expenseDeclaration.setDateCreation(Instant.now());

        return expenseDeclaration;
    }

    public void handleDetails(ExpenseDeclaration declaration) {
        // Handle details logic
    }

    public void handleTransport(ExpenseDeclaration declaration) {
        // Handle transport logic
    }

    public void handleAccommodation(ExpenseDeclaration declaration) {
        // Handle accommodation logic
    }

    public void handleMeal(ExpenseDeclaration declaration) {
        // Handle meal logic
    }

    public void handleBankDetails(ExpenseDeclaration declaration) {
        // Handle bank details logic
    }

    public void handleReview(ExpenseDeclaration declaration) {
        // Handle review logic
    }

    public void handleSubmit(ExpenseDeclaration declaration) {
        // Handle submission logic
    }
}
