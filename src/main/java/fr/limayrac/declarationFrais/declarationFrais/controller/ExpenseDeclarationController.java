package fr.limayrac.declarationFrais.declarationFrais.controller;

import fr.limayrac.declarationFrais.declarationFrais.model.ExpenseDeclaration;
import fr.limayrac.declarationFrais.declarationFrais.service.ExpenseDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expenseDeclaration")
public class ExpenseDeclarationController {

    private final ExpenseDeclarationService expenseDeclarationService;

    @Autowired
    public ExpenseDeclarationController(ExpenseDeclarationService expenseDeclarationService) {
        this.expenseDeclarationService = expenseDeclarationService;
    }

    @GetMapping("/prepare")
    public String prepareExpenseDeclaration(Model model) {
        // Initialize and prepare the expenseDeclaration object
        ExpenseDeclaration expenseDeclaration = new ExpenseDeclaration();
        model.addAttribute("expenseDeclaration", expenseDeclaration);
        return "expenseDeclaration/prepare";
    }

    @PostMapping("/details")
    public String declareDetails(@ModelAttribute("expenseDeclaration") ExpenseDeclaration expenseDeclaration) {
        // Handle details submission
        expenseDeclarationService.handleDetails(expenseDeclaration);
        return "expenseDeclaration/details";
    }

    @PostMapping("/transport")
    public String declareTransport(@ModelAttribute("expenseDeclaration") ExpenseDeclaration expenseDeclaration) {
        // Handle transport details submission
        expenseDeclarationService.handleTransport(expenseDeclaration);
        return "expenseDeclaration/transport";
    }

    @PostMapping("/accommodation")
    public String declareAccommodation(@ModelAttribute("expenseDeclaration") ExpenseDeclaration expenseDeclaration) {
        // Handle accommodation details submission
        expenseDeclarationService.handleAccommodation(expenseDeclaration);
        return "expenseDeclaration/accommodation";
    }

    @PostMapping("/meal")
    public String declareMeal(@ModelAttribute("expenseDeclaration") ExpenseDeclaration expenseDeclaration) {
        // Handle meal details submission
        expenseDeclarationService.handleMeal(expenseDeclaration);
        return "expenseDeclaration/meal";
    }

    @PostMapping("/bankDetails")
    public String declareBankDetails(@ModelAttribute("expenseDeclaration") ExpenseDeclaration expenseDeclaration) {
        // Handle bank details submission
        expenseDeclarationService.handleBankDetails(expenseDeclaration);
        return "expenseDeclaration/bankDetails";
    }

    @PostMapping("/review")
    public String reviewExpenseDeclaration(@ModelAttribute("expenseDeclaration") ExpenseDeclaration expenseDeclaration, Model model) {
        // Handle review submission
        expenseDeclarationService.handleReview(expenseDeclaration);
        model.addAttribute("expenseDeclaration", expenseDeclaration);
        return "expenseDeclaration/review";
    }

    @PostMapping("/submit")
    public String submitExpenseDeclaration(@ModelAttribute("expenseDeclaration") ExpenseDeclaration expenseDeclaration) {
        // Handle submission
        expenseDeclarationService.handleSubmit(expenseDeclaration);
        return "expenseDeclaration/submit";
    }
}
