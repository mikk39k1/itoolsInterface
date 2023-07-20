package com.example.itoolsinterface.controller;


import com.example.itoolsinterface.model.Login;
import com.example.itoolsinterface.service.LoginService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/signin")
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new Login());
        return "authorization/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("loginRequest") @Valid Login login, BindingResult result, HttpSession session) {
        Login.LoginResult loginRequest = loginService.loginUser(login.getLoginUsername(), login.getLoginPassword());

        if (loginRequest == Login.LoginResult.SUCCESS) {
            Login user = loginService.getLoginSession(login.getLoginUsername(), login.getLoginPassword());
            session.setAttribute("user", user);
            return "home/index";

        } else {
            if (loginRequest == Login.LoginResult.INCORRECT_USERNAME) {
                result.rejectValue("loginUsername", "error.login", "miss match username or password");
            } else {
                result.rejectValue("loginPassword", "error.login", "miss match username or password");
            }
            return "authorization/login";
        }
    }


    @GetMapping("/logOut")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "authorization/accessDenied";
    }


}