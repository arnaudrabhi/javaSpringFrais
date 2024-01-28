package fr.limayrac.declarationFrais.declarationFrais.service;

import fr.limayrac.declarationFrais.declarationFrais.controller.UserController;
import fr.limayrac.declarationFrais.declarationFrais.enums.statutDeclaration;
import fr.limayrac.declarationFrais.declarationFrais.model.*;
import fr.limayrac.declarationFrais.declarationFrais.repository.BankDetailsRepository;
import fr.limayrac.declarationFrais.declarationFrais.repository.ExpenseDeclarationRepository;
import fr.limayrac.declarationFrais.declarationFrais.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service("expenseDeclarationService")
public class ExpenseDeclarationService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseDeclarationService.class);

    @Autowired
    private ExpenseDeclarationRepository expenseDeclarationRepository;

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    public ExpenseDeclaration startNewDeclaration() {

        ExpenseDeclaration expenseDeclaration = new ExpenseDeclaration();
        expenseDeclaration.setDateCreation(Instant.now());
        expenseDeclaration.setCreated_at(Instant.now());
        expenseDeclaration.setStatut(statutDeclaration.EN_ATTENTE);

        logger.info("expenseDeclaration créée !");

        expenseDeclarationRepository.save(expenseDeclaration);

        return expenseDeclaration;
    }

    public ExpenseDeclaration saveDeclaration(ExpenseDeclaration declaration) {
        expenseDeclarationRepository.save(declaration);
        return declaration;
    }

    public List<BankDetails> getUserBankDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User loggedInUser = customUserDetails.getUser();

        logger.info("User récupéré" + loggedInUser);

        List<BankDetails> listBankDetails = bankDetailsRepository.getByUser(loggedInUser);

        logger.info(listBankDetails.toString());

        return listBankDetails;

    }


    public void addTransportExpense(ExpenseDeclaration declaration, TransportExpense transportExpense) {
        declaration.addTransportExpense(transportExpense);
    }

    public void addAccommodationExpense(ExpenseDeclaration declaration) {
        declaration.addAccommodationExpense(new AccommodationExpense());
    }

    public void addMealExpense(ExpenseDeclaration declaration, MealExpense mealExpense) {
        declaration.addMealExpense(mealExpense);
    }

    public ExpenseDeclaration findByUserId(Long userId) {
        return expenseDeclarationRepository.findByUserId(userId);
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
