package fr.limayrac.declarationFrais.declarationFrais.controller;

import fr.limayrac.declarationFrais.declarationFrais.model.BankDetails;
import fr.limayrac.declarationFrais.declarationFrais.model.User;
import fr.limayrac.declarationFrais.declarationFrais.security.CustomUserDetails;
import fr.limayrac.declarationFrais.declarationFrais.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/bankDetails")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping("/list")
    public String listBankDetails(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User loggedInUser = customUserDetails.getUser();

        model.addAttribute("bankDetailsList", bankDetailsService.getBankByUser(loggedInUser));
        return "bankDetails/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("bankDetails", new BankDetails());
        return "bankDetails/add";
    }

    @PostMapping("/add")
    public String addBankDetails(@ModelAttribute("bankDetails") BankDetails bankDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User loggedInUser = customUserDetails.getUser();
        bankDetails.setUser(loggedInUser);
        bankDetailsService.saveBankDetails(bankDetails);
        return "redirect:/bankDetails/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        BankDetails bankDetails = bankDetailsService.getBankDetailsById(id);
        if (bankDetails != null) {
            model.addAttribute("bankDetails", bankDetails);
            return "bankDetails/edit";
        }
        return this.listBankDetails(model);
    }

    @PostMapping("/edit/{id}")
    public String updateBankDetails(@PathVariable("id") Long id, @ModelAttribute("bankDetails") BankDetails bankDetails) {
        bankDetails.setId(id);
        bankDetailsService.saveBankDetails(bankDetails);
        return "redirect:/bankDetails/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBankDetails(@PathVariable("id") Long id) {
        bankDetailsService.deleteBankDetails(id);
        return "redirect:/bankDetails/list";
    }
}
