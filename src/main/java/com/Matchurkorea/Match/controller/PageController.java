package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.Spot;
import com.Matchurkorea.Match.service.SpotService;
import com.Matchurkorea.Match.service.TourService;
import com.Matchurkorea.Match.service.UserService;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
public class PageController {

    private final UserService userService;
    private final TourService tourService;
    private final SpotService spotService;

    //private final PostService
    public PageController(UserService userService, TourService tourService, SpotService spotService) {
        this.userService = userService;
        this.tourService = tourService;
        this.spotService = spotService;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
       // model.addAttribute("posts",pos)
       // model.addAttribute("name",principal.getName())
        return "home";
    }


    @GetMapping(value = "/travel")
    public String travel(Model model) {
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
    @GetMapping("/swipertest")
    public String swipertest(Model model){
        return "characterListex";
    }

    @GetMapping("/testVideo")
    public String testVideo(Model model,Principal principal,
                            @RequestParam("c1") String c1,@RequestParam("c2") String c2,
                            @RequestParam("c3") String c3,@RequestParam("c4") String c4,@RequestParam("c5") String c5,@RequestParam("tour_local") String tour_local) throws IOException, ParseException {
        //로그인 한 경우 db에 선택 코스 저장하기
        String user_id=principal.getName();
        tourService.saveTour(tour_local,c1,user_id);
        tourService.saveTour(tour_local,c2,user_id);
        tourService.saveTour(tour_local,c3,user_id);
        tourService.saveTour(tour_local,c4,user_id);
        tourService.saveTour(tour_local,c5,user_id);
        String image1=spotService.getSpotImg(c1);
        String image2=spotService.getSpotImg(c2);
        String image3=spotService.getSpotImg(c3);
        String image4=spotService.getSpotImg(c4);
        String image5=spotService.getSpotImg(c5);
        model.addAttribute("image1",image1);
        model.addAttribute("image2",image2);
        model.addAttribute("image3",image3);
        model.addAttribute("image4",image4);
        model.addAttribute("image5",image5);
        //TODO content id값으로 이미지와 이름 가져오기
        return "testVideo";
    }


    @GetMapping("/mytravel")
    public String mytravel(Model model) {
        return "mytravel";
    }
}
