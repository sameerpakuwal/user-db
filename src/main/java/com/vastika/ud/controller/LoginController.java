package com.vastika.ud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(){

        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/login_err")
    public String getLoginErrPage(Model model){
    model.addAttribute("loginFailMsg", "Wrong Username or Password!");
        return "login";
    }
    @GetMapping("/logout")
    public String getLogout(Model model){
        model.addAttribute("logoutmsg", "You have sucessfully logged out!");
        return "login";
    }

}
