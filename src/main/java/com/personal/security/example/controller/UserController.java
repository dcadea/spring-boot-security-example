package com.personal.security.example.controller;

import com.personal.security.example.model.dto.NewUserDto;
import com.personal.security.example.service.SecurityService;
import com.personal.security.example.service.UserService;
import com.personal.security.example.util.URLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import static com.personal.security.example.util.Templates.*;

@Controller
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;

    @Autowired
    public UserController(final UserService userService,
                          final SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping(URLs.REGISTRATION)
    public String registration(final Model model) {
        model.addAttribute("newUserDto", new NewUserDto());
        return REGISTRATION;
    }

    @PostMapping(URLs.REGISTRATION)
    public String registration(@Valid final NewUserDto newUserDto, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return REGISTRATION;
        }

        userService.save(newUserDto.user());
        securityService.authenticate(newUserDto.getUsername(), newUserDto.getPassword());

        return redirect(ROOT);
    }

}
