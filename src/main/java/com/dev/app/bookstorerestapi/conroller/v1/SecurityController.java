package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.User;
import com.dev.app.bookstorerestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class SecurityController {

    public static final String SECURITY_REGISTRATION_FORM = "security/registrationForm";

    @Autowired
    public UserService userService;

    @GetMapping("/login")
    public String login() {
        return "security/login";
    }

    @RequestMapping("/registering")
    public String RegistrationForm(Model model){
        model.addAttribute("user", new User());
        return SECURITY_REGISTRATION_FORM;
    }

    @PostMapping("/registering")
    public String submitRegistration(@Valid @ModelAttribute("user") User user,
                                     BindingResult result,
                                     Model model){
        if(result.hasErrors()){
            return SECURITY_REGISTRATION_FORM;
        }


        User foundedUserByUseName = userService.findByUserName(user.getUserName());
        User foundedUserByEmail = userService.findByEmail(user.getEmail());

        if(foundedUserByUseName != null){

            model.addAttribute("exists", true);
            model.addAttribute("errorMessage", "The UserName already exists. Please choose another UserName!");

            return SECURITY_REGISTRATION_FORM;

        }else if(foundedUserByEmail != null){

            model.addAttribute("exists", true);
            model.addAttribute("errorMessage", "The email already exists. Please choose another email!");
            return SECURITY_REGISTRATION_FORM;

        }

        User savedUser = userService.register(user);
        return "security/register_success";

    }
}
