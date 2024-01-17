package fr.limayrac.declarationFrais.declarationFrais.controller;


import fr.limayrac.declarationFrais.declarationFrais.model.User;
import fr.limayrac.declarationFrais.declarationFrais.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "auth/register";
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") User userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "auth/register";
        }

        userService.saveUser(userDto);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = (List<User>) userService.getUsers();
        model.addAttribute("users", users);
        return "admin/userList";
    }
}