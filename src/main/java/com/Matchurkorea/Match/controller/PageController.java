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
    public String home(Model model){
        return "home";
    }
    @GetMapping(value="/travel")
    public String travel(Model model){
        return "travel";
    }
    @GetMapping(value="/test")
    public String test(Model model){
        return "testPage";
    }
    @GetMapping(value="/testResult")
    public String testResult(Model model){
        return "testResult";
    }

    @GetMapping("/explore")
    public String explore(Model model){
        return "exploreImageMap";
    }
}
