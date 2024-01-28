package fr.limayrac.declarationFrais.declarationFrais.controller;

import fr.limayrac.declarationFrais.declarationFrais.enums.statutDeclaration;
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
    public String showMyExpenseDeclarations(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User loggedInUser = customUserDetails.getUser();

        List<ExpenseDeclaration> expenseDeclarations = expenseDeclarationRepository.findByUser(loggedInUser);

        model.addAttribute("expenseDeclarations", expenseDeclarations);

        return "expenseDeclaration/myList";
    }


    @GetMapping("/all")
    public String showAllExpenseDeclarations(Model model) {
        List<ExpenseDeclaration> expenseDeclarations = expenseDeclarationRepository.findAll();
        model.addAttribute("expenseDeclarations", expenseDeclarations);

        return "expenseDeclaration/list";
    }

    @GetMapping("/details/{id:[\\d]+}")
    public String showExpenseDeclarationDetails(@PathVariable Long id, Model model) {
        Optional<ExpenseDeclaration> expenseDeclaration = expenseDeclarationRepository.findById(id);

        if (expenseDeclaration.isPresent()) {
            model.addAttribute("expenseDeclaration", expenseDeclaration.get());
            return "expenseDeclaration/details";
        }

        return showMyExpenseDeclarations(model);
    }


    @PostMapping("/validate/{id:[\\d]+}")
    public String validateExpenseDeclaration(@PathVariable Long id, Model model) {
        Optional<ExpenseDeclaration> optionalExpenseDeclaration = expenseDeclarationRepository.findById(id);

        if (optionalExpenseDeclaration.isPresent()) {
            ExpenseDeclaration expenseDeclaration = optionalExpenseDeclaration.get();
            expenseDeclaration.setStatut(statutDeclaration.VALIDE); // Mettez à jour le statut

            // Ajoutez ici le code pour enregistrer la mise à jour dans le repository

            // Redirigez vers la page de la liste des déclarations après la validation
            return "redirect:/declaration/all";
        }

        return showAllExpenseDeclarations(model);
    }

    @PostMapping("/invalidate/{id:[\\d]+}")
    public String invalidateExpenseDeclaration(@PathVariable Long id, Model model) {
        Optional<ExpenseDeclaration> optionalExpenseDeclaration = expenseDeclarationRepository.findById(id);

        if (optionalExpenseDeclaration.isPresent()) {
            ExpenseDeclaration expenseDeclaration = optionalExpenseDeclaration.get();
            expenseDeclaration.setStatut(statutDeclaration.INVALIDE); // Mettez à jour le statut

            // Ajoutez ici le code pour enregistrer la mise à jour dans le repository

            // Redirigez vers la page de la liste des déclarations après l'invalidation
            return "redirect:/declaration/all";
        }

        return showAllExpenseDeclarations(model);
    }
}
