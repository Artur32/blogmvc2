package blog.controllers;



import blog.forms.LoginForm;
import blog.services.LoginService;
import blog.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Objects;
/**
 * Created by Artur on 2017-06-14.
 */
public class PostsController {@Autowired
    private NotificationService notificationService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/users/login")
    public String showLoginForm(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login",
            method = RequestMethod.POST)
    public String showLoginForm(
            @Valid LoginForm loginForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            notificationService.addErrorMessage(
                    "Sample mvc");
            return "users/login";
        }

        if (! loginService.authentice(loginForm.getUsername(),
                loginForm.getPassword())) {
            notificationService.addErrorMessage("Invalid login");
            return "users/login";
        }

        // Login successful
        notificationService.addInfoMessage("Welcome!");
        return "redirect:/";
    }
}