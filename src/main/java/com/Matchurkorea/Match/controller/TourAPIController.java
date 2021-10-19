package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.Area;
import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.Spot;
import com.Matchurkorea.Match.service.SpotService;
import com.Matchurkorea.Match.service.UserService;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class TourAPIController<map> {

    private final UserService userService;
    private final SpotService spotService;

    @Autowired
    public TourAPIController(UserService userService, SpotService spotService){
        this.userService = userService;
        this.spotService = spotService;
    }
    private String exploreView = "redirect:/explore/";

    @GetMapping(value= "/explore/character/{characterCode}")
    public String exploreByCharacter(Model model, @PathVariable(value = "characterCode") String characterCode) throws IOException, ParseException {
        List<Character> character = userService.getCharacterList(characterCode);
        List<String> codes = new ArrayList<String>();
        codes.add(character.get(0).getCat1());
        codes.add(character.get(0).getCat2());
        codes.add(character.get(0).getCat3());
        codes.removeAll(Arrays.asList("", null));
        List<Spot> list = spotService.findSpotByCharacter(codes);
        model.addAttribute("character", character.get(0));
        model.addAttribute("spotList",list);
        return "characterSpot";
    }

    @GetMapping(value="/explore/area/{areaCode}")
    public String exploreByArea(Model model, @PathVariable(value = "areaCode") String areaCode) throws IOException,ParseException {
        List<Spot> list = spotService.findSpotByArea(areaCode);
        model.addAttribute("spotList", list);

        // areaCode에서 지역명 얻기
        Area area = Area.of(areaCode);
        String areaName = area.name();
        model.addAttribute("areaName", areaName);

        return "areaSpot";
    }

    //TODO html 생성
    @GetMapping(value="/explore/details/{contentid}")
    public String exploreDetailSpot(Model model, @PathVariable(value="contentid") String contentid) throws IOException, ParseException{
        List<Spot> list = spotService.getSpotDetail(contentid);
        model.addAttribute("spot", list.get(0));
        return "spotDetails";
    }

    @GetMapping(value="callDetail")
    public void callDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam String contentid) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        JSONObject json = spotService.getSpotOverview(contentid);
    }
    @GetMapping(value="/testResult/{characterCode}/{areaCode}")
    public String exploreByType(Model model,
                                @PathVariable(value = "areaCode") String areaCode,
                                @PathVariable(value = "characterCode") String characterCode) throws IOException, ParseException {
        List<Character> character = userService.getCategoryList(characterCode);
        List<String> codes = new ArrayList<String>();
        codes.add(character.get(0).getCat1());
        codes.add(character.get(0).getCat2());
        codes.add(character.get(0).getCat3());
        codes.removeAll(Arrays.asList("", null));
        List<Spot> list = spotService.findSpotByType(codes,areaCode);

        model.addAttribute("spotList", list);
        return "areaSpot";
    }



}
