package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAllUsers(Model model){
        model.addAttribute("title", "All Users");
        return "user/index";
    }
    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user,
                                      Errors errors, Model model) {

        if (errors.hasErrors() && user.getPassword().equals(user.getVerify())){
            model.addAttribute("user", user);
            return "user/add";
        }
        model.addAttribute("user", user);
        return "user/index";

    }


}
