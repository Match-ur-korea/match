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
    public String exploreByCharacter(Model model, @PathVariable(value = "characterCode") String characterCode,
                                     @RequestParam(defaultValue = "1") int page) throws IOException, ParseException {
        List<Character> character = userService.getCharacterList(characterCode);
        List<String> codes = new ArrayList<String>();
        // TODO error catch
        codes.add(character.get(0).getCat1());
        codes.add(character.get(0).getCat2());
        codes.add(character.get(0).getCat3());
        codes.removeAll(Arrays.asList("", null));
        model.addAttribute("character", character.get(0));

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

        // 페이징
        Pagination pagination = new Pagination(totalCount, page);
        model.addAttribute("pagination", pagination);

        return "characterSpot";
    }

    @GetMapping(value="/explore/area/{areaCode}")
    public String exploreByArea(Model model, @PathVariable(value = "areaCode") String areaCode,
                                @RequestParam(defaultValue = "1") int page) throws IOException,ParseException {

        // areaCode에서 지역명 얻기
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

        // 페이징
        Pagination pagination = new Pagination(totalCount, page);
        model.addAttribute("pagination", pagination);

        return "areaSpot";
    }

    //TODO html 생성
    @GetMapping(value="/explore/details/{contentid}")
    public String exploreDetailSpot(Model model,
                                    @PathVariable(value="contentid") String contentid) throws IOException, ParseException{
        Detail detail = spotService.getSpotDetail(contentid);
        model.addAttribute("detail", detail);
        return "spotDetails";
    }

    @GetMapping(value = "/testResult")
    public String testResult(Model model,
                             @RequestParam(value = "selectId") String selectId,
                             @RequestParam(value = "local") String local,
                             @RequestParam(defaultValue = "1") int page) throws IOException, ParseException {
        int totalCount=0;
        List<Spot> list = new ArrayList<Spot>();
        List<Character> character = userService.getCharacterList(selectId);
        List<String> codes = new ArrayList<String>();
        codes.add(character.get(0).getCat1());
        codes.add(character.get(0).getCat2());
        codes.add(character.get(0).getCat3());
        codes.removeAll(Arrays.asList("", null));
        Map<Integer, List<Spot>> map = spotService.findSpotByType(codes, local, page);
        for(Map.Entry<Integer, List<Spot>> elem : map.entrySet()){
            totalCount = elem.getKey().intValue();
            list = elem.getValue();
        }
        System.out.println("확인");
        List<String> overview=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            overview.add(spotService.getSpotContent(list.get(i).getContentid().toString()));
        }
        model.addAttribute("local", local);
        model.addAttribute("characters", character);
        model.addAttribute("spotList", list);
        model.addAttribute("contents",overview);
        return "testResult";
    }

    // TODO 호버 시 잘 보이는지 확인
    @GetMapping(value="callDetail")
    public String callDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam String contentid) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        return spotService.getSpotOverview(contentid);
    }

}
