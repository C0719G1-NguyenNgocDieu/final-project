package com.codegym.controller;

import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.service.RoleService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public ModelAndView listUser(){
        ModelAndView modelAndView = new ModelAndView("user/home");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;

    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());

        return "user/registry";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String role){
        if (userService.findByName(email)==null){
            User user1 = new User();
            user1.setEmail(email);
            user1.setPassword(passwordEncoder.encode(password));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleService.findByName(role));
            user1.setRoles(roles);
            userService.save(user1);
        }
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Integer id){
        model.addAttribute("user",userService.findById(id)) ;
        return "user/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String role,
                         @RequestParam Integer id){
        if (userService.findByName(email)==null) {
            User user = userService.findById(id);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleService.findByName(role));
            user.setRoles(roles);
            userService.save(user);
        }
        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String deleteForm(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user/delete";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer id){
        userService.deleteById(id);
        return "redirect:/home";
    }
}
