package fr.limayrac.declarationFrais.declarationFrais.controller;

import fr.limayrac.declarationFrais.declarationFrais.model.Role;
import fr.limayrac.declarationFrais.declarationFrais.model.User;
import fr.limayrac.declarationFrais.declarationFrais.service.UserService;
import fr.limayrac.declarationFrais.declarationFrais.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "/new")
    public String showCreateUserForm(Model model) {
        User user = new User();
        List<Role> roles = (List<Role>) roleRepository.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("user", new User());
        return "user/newUserForm";
    }

    @PostMapping("/new")
    public String submit(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Role> roles = (List<Role>) roleRepository.findAll();
            model.addAttribute("roles", roles);
            return "user/newUserForm";
        }
        userService.saveUser(user);
        return listUser(model);
    }

    @GetMapping(value = "/edit/{id:[\\d]+}")
    public String editUser(Model model, @PathVariable("id") final Long id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            User finalUser = user.get();
            model.addAttribute("user", finalUser);
            return "user/editUserForm";
        }
        model.addAttribute("error", "L'utilisateur n'existe pas");
        return listUser(model);
    }

    @PostMapping(value = "/edit/{id:[\\d]+}")
    public String showEditedUser(@ModelAttribute("user") User user, Model model) {
        userService.saveUser(user);
        return listUser(model);
    }

    @GetMapping(value = "/delete/{id:[\\d]+}")
    public String deleteUserConfirmation(Model model, @PathVariable("id") final Long id) {
        Optional<User> user = userService.getUser(id);
        if (user.isEmpty()) {
            model.addAttribute("error", "L'utilisateur n'existe pas");
            return listUser(model);
        }
        model.addAttribute("user", user.get());
        return "user/userDeleteConfirmation";
    }

    @PostMapping(value = "/delete/{id:[\\d]+}")
    public String deleteUser(@PathVariable("id") final Long id, Model model) {
        userService.deleteUser(id);
        return listUser(model);
    }


    @GetMapping("/list")
    public String listUser(Model model) {
        Iterable<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/userList";
    }

}

