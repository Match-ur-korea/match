package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.Spot;
import com.Matchurkorea.Match.service.TourService;
import com.Matchurkorea.Match.service.UserService;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
public class PageController {

    private final UserService userService;
    private final TourService tourService;
    //private final PostService
    public PageController(UserService userService, TourService tourService) {
        this.userService = userService;
        this.tourService = tourService;
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

    @GetMapping(value = "/test")
    public String test(Model model) {
        return "testPage";
    }

    @GetMapping("/explore")
    public String explore(Model model){
        List<Character> list = userService.getAllCharacterList();
        model.addAttribute("characters",list);
        return "explore";
    }

    @GetMapping("/testVideo")
    public String testVideo(Model model,Principal principal,
                            @RequestParam("c1") String c1,@RequestParam("c2") String c2,
                            @RequestParam("c3") String c3,@RequestParam("c4") String c4,@RequestParam("c5") String c5,@RequestParam("tour_local") String tour_local) throws IOException {
        //String s=principal.getName();
        //로그인 한 경우 db에 선택 코스 저장하기
        String user_id=principal.getName();
        tourService.saveTour(tour_local,c1,user_id);
        tourService.saveTour(tour_local,c2,user_id);
        tourService.saveTour(tour_local,c3,user_id);
        tourService.saveTour(tour_local,c4,user_id);
        tourService.saveTour(tour_local,c5,user_id);
        //TODO content id값으로 이미지와 이름 가져오기
        //String select1=tourService.getImg(c1);
        // model.addAttribute("c1",select1);
        return "testVideo";
    }


    @GetMapping("/mytravel")
    public String mytravel(Model model) {
        return "mytravel";
    }
    @GetMapping("/swipertest")
    public String swipertest(Model model){
        return "characterListex";
    }

}
