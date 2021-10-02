package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.Spot;
import com.Matchurkorea.Match.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Controller
public class TourAPIController {

    private final SpotService spotService;

    @Autowired
    public TourAPIController(SpotService spotService){
        this.spotService = spotService;
    }
    private String exploreView = "redirect:/explore/";

    @GetMapping(value= "/explore/character/{characterCode}")
    public String exploreByCharacter(Model model, @PathVariable(value = "characterCode") String characterCode) throws IOException, ParseException {
        List<Spot> list = spotService.findSpotByCharacter(characterCode);
        model.addAttribute("spotList",list);
        return "characterSpot"; // TODO : html 파일 이름이랑 같이 변경
    }

    @GetMapping(value="/explore/area/{areaCode}")
    public String exploreByArea(Model model, @PathVariable(value = "areaCode") String areaCode) throws IOException {
        List<Spot> list = spotService.findSpotByArea(areaCode);
        model.addAttribute("spotList", list);
        return "areaSpot";
    }

    @GetMapping(value="/testResult/{characterCode}/{areaCode}")
    public String exploreByType(Model model,
                                @PathVariable(value = "areaCode") String areaCode,
                                @PathVariable(value = "characterCode") String characterCode) throws IOException {
        List<Spot> list = spotService.findSpotByType(characterCode,areaCode);

        model.addAttribute("spotList", list);
        return "areaSpot";
    }

}
