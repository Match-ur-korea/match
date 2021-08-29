package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.User;
import com.Matchurkorea.Match.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    private final UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/")
    public String list(Model model){
        model.addAttribute("data","hello!");
        return "home";
    }
}
