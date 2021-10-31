package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.Area;
import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.Spot;
import com.Matchurkorea.Match.domain.Tour;
import com.Matchurkorea.Match.service.SpotService;
import com.Matchurkorea.Match.service.TourService;
import com.Matchurkorea.Match.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.json.simple.parser.ParseException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.security.Principal;

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
                            @RequestParam("c1") String c1, @RequestParam("c2") String c2,
                            @RequestParam("c3") String c3, @RequestParam("c4") String c4, @RequestParam("c5") String c5, @RequestParam("tour_local") String tour_local) throws IOException, ParseException {

        String user_id="";
        if(principal!=null) {
            user_id = principal.getName();
            tourService.saveTour(tour_local, c1, user_id);
            tourService.saveTour(tour_local, c2, user_id);
            tourService.saveTour(tour_local, c3, user_id);
            tourService.saveTour(tour_local, c4, user_id);
            tourService.saveTour(tour_local, c5, user_id);
        }
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


    @GetMapping(value="/myTravel/{areaCode}")
    public String myTravelInTheArea(Model model, Principal principal,
                                    @PathVariable(value="areaCode") String areaCode) throws IOException, ParseException{
        String user_id = principal.getName();
        List<Tour> list = tourService.getTourInTheArea(user_id,areaCode);
        List<String> imageList = new ArrayList<String>();
        for (Tour tour : list){
            System.out.println(tour.getContentId());
            imageList.add(spotService.getSpotImg(String.valueOf(tour.getContentId())));
        }
        System.out.println(imageList);
        model.addAttribute("imageList",imageList);
        return "myTravelInTheArea";
    }
    @GetMapping("/swipertest")
    public String swipertest(Model model){
        return "characterList";
    }

}
