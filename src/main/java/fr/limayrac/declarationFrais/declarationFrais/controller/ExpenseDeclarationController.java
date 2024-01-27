package fr.limayrac.declarationFrais.declarationFrais.controller;

import fr.limayrac.declarationFrais.declarationFrais.model.ExpenseDeclaration;
import fr.limayrac.declarationFrais.declarationFrais.model.User;
import fr.limayrac.declarationFrais.declarationFrais.repository.ExpenseDeclarationRepository;
import fr.limayrac.declarationFrais.declarationFrais.security.CustomUserDetails;
import fr.limayrac.declarationFrais.declarationFrais.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/declaration")
public class ExpenseDeclarationController {

    @Autowired
    private ExpenseDeclarationRepository expenseDeclarationRepository;
    @Autowired
    private UserService userService;



    @GetMapping("/mes-declarations")
    public String showExpenseDeclarations(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Fetch the logged-in user
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User loggedInUser = customUserDetails.getUser();

        // Fetch expense declarations for the user
        List<ExpenseDeclaration> expenseDeclarations = expenseDeclarationRepository.findByUser(loggedInUser);

        // Add expense declarations to the model
        model.addAttribute("expenseDeclarations", expenseDeclarations);

        return "expenseDeclaration/list"; // This assumes you have a Thymeleaf template named "list.html"
    }

    @GetMapping("/{id}")
    public String showExpenseDeclarationDetails(@PathVariable Long id, Model model) {
        // Fetch the expense declaration by ID
        Optional<ExpenseDeclaration> expenseDeclaration = expenseDeclarationRepository.findById(id);



        // Add expense declaration details to the model
        model.addAttribute("expenseDeclaration", expenseDeclaration);

        return "expenseDeclaration/details"; // This assumes you have a Thymeleaf template named "details.html"
    }


}
