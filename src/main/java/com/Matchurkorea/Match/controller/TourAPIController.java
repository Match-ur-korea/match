package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.Area;
import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.Detail;
import com.Matchurkorea.Match.domain.Spot;
import com.Matchurkorea.Match.paging.Pagination;
import com.Matchurkorea.Match.service.SpotService;
import com.Matchurkorea.Match.service.UserService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
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

    @GetMapping(value= "explore/character/{characterCode}")
    public String exploreByCharacter(Model model, @PathVariable(value = "characterCode") String characterCode,
                                     @RequestParam(defaultValue = "1") int page) throws IOException, ParseException {
        Character myCharacter = userService.getCharacterList(characterCode);
        List<String> codes = new ArrayList<String>();
        codes.add(myCharacter.getCat1());
        codes.add(myCharacter.getCat2());
        codes.add(myCharacter.getCat3());
        codes.removeAll(Arrays.asList("", null));
        model.addAttribute("myCharacter", myCharacter);

        List<Character> characterList = userService.getAllCharacterList();
        model.addAttribute("characterList", characterList);

        int totalCount = 0;
        List<Spot> list = new ArrayList<Spot>();
        Map<Integer, List<Spot>> map = spotService.findSpotByCharacter(codes, page);
        for(Map.Entry<Integer, List<Spot>> elem : map.entrySet()){
            totalCount = elem.getKey().intValue();
            list = elem.getValue();
        }
        model.addAttribute("spotList",list);

        return "characterSpot";
    }

    @GetMapping(value="explore/area/{areaCode}")
    public String exploreByArea(Model model, @PathVariable(value = "areaCode") String areaCode,
                                @RequestParam(defaultValue = "1") int page) throws IOException,ParseException {

        // areaCode?????? ????????? ??????
        Area area = Area.of(areaCode);
        String areaName = area.name();
        model.addAttribute("areaName", areaName);

        int totalCount = 0;
        List<Spot> list = new ArrayList<Spot>();
        Map<Integer, List<Spot>> map = spotService.findSpotByArea(areaCode, page);
        for(Map.Entry<Integer, List<Spot>> elem : map.entrySet()){
            totalCount = elem.getKey().intValue();
            list = elem.getValue();
        }
        model.addAttribute("spotList", list);

        // ?????????
        Pagination pagination = new Pagination(totalCount, page);
        model.addAttribute("pagination", pagination);

        return "areaSpot";
    }

    @GetMapping(value="explore/details/{contentid}")
    public String exploreDetailSpot(Model model,
                                    @PathVariable(value="contentid") String contentid) throws IOException, ParseException{
        Detail detail = spotService.getSpotDetail(contentid);
        model.addAttribute("detail", detail);
        return "spotDetails";
    }

    @GetMapping(value = "testResult")
    public String testResult(Model model, Principal principal,
                             @RequestParam(value = "selectId") String selectId,
                             @RequestParam(value = "local") String local,
                             @RequestParam(defaultValue = "1") int page) throws IOException, ParseException {
        String user_id="";
        if(principal!=null) {
            user_id = principal.getName();
            userService.saveCharacter(user_id,selectId);
        }
        int totalCount=0;
        List<Spot> list = new ArrayList<Spot>();
        Character character = userService.getCharacterList(selectId);
        List<String> codes = new ArrayList<String>();
        codes.add(character.getCat1());
        codes.add(character.getCat2());
        codes.add(character.getCat3());
        codes.removeAll(Arrays.asList("", null));

        Map<Integer, List<Spot>> map = spotService.findSpotByType(codes, local, page);
        for(Map.Entry<Integer, List<Spot>> elem : map.entrySet()){
            totalCount = elem.getKey().intValue();
            list = elem.getValue();
        }
        model.addAttribute("local", local);
        model.addAttribute("character", character);
        model.addAttribute("spotList", list);
        return "testResult";
    }

    @GetMapping("selectLocal")
    public String selectLocal(Model model) {
        return "selectLocal";
    }

    @GetMapping("myTestResult")
    public String myTestResult(Model model, Principal principal, @RequestParam("local") String local,
                               @RequestParam(defaultValue = "1") int page) throws IOException, ParseException {
        String user_id = principal.getName();
        //user_id??? select_id ????????????
        String selectId = userService.getUserCharacter(user_id);
        Character character = userService.getCharacterList(selectId);
        List<String> codes = new ArrayList<String>();
        codes.add(character.getCat1());
        codes.add(character.getCat2());
        codes.add(character.getCat3());
        codes.removeAll(Arrays.asList("", null));

        int totalCount =0;
        List<Spot> list = new ArrayList<Spot>();
        Map<Integer, List<Spot>> map = spotService.findSpotByType(codes, local, page);
        for(Map.Entry<Integer, List<Spot>> elem : map.entrySet()){
            totalCount = elem.getKey().intValue();
            list = elem.getValue();
        }

        model.addAttribute("local", local);
        model.addAttribute("character", character);
        model.addAttribute("spotList", list);
        return "myTestResult";
    }


}
