package com.vastika.ud.controller;

import com.vastika.ud.model.User;
import com.vastika.ud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String getUser(){
        return "createUser";
    }
    @GetMapping("/edit")
    public String editUser(@RequestParam int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user){
            userService.saveUser(user);
        return "redirect:/list";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/list";
    }

    @GetMapping(value = "/list")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "listUser";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id){
        userService.deleteUser(id);
        return "redirect:/list";
    }

}
