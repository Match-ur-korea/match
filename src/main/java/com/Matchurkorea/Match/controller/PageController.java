package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping(value="/introUs")
    public String introduce(Model model){
        return "introUs";
    }
    @GetMapping(value="/travel")
    public String travel(Model model){
        return "travel";
    }
    @GetMapping(value="/test")
    public String test(Model model){
        model.addAttribute("selectId",1);
        return "testPage";
    }
    @RequestMapping("/testResult")
    public String testResult(HttpServletRequest httpServletRequest, Model model) {
        String s=httpServletRequest.getParameter("selectId");
        List<Character> list=userService.getCharacterList(s);
        model.addAttribute("characters",list);
        return "testResult";
    }

    @GetMapping("/explore")
    public String explore(Model model){
        List<Character> list = userService.getAllCharacterList();
        model.addAttribute("characters",list);
        return "explore";
    }

    @GetMapping("/swipertest")
    public String swipertest(Model model){
        return "characterListex";
    }
}
