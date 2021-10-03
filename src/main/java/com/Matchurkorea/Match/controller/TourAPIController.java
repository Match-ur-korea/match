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
//    @Autowired
    private final SpotService spotService;
//    @Value("${tourapi.key}")
//    private String key;
    public TourAPIController(SpotService spotService){
        this.spotService = spotService;
    }
    private String exploreView = "redirect:/explore/";

//    @GetMapping("/apitest")
//public String callTourApi() throws IOException{
//    StringBuilder result = new StringBuilder();
//    // Encoding된 키
//    try{
//        String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="+key
//                +"&contentTypeId="
//                +"&areaCode="
//                +"&sigunguCode="
//                +"&cat1=A01" //카테고리
//                +"&cat2=A0101"
//                +"&cat3=A01010700"
//                +"&listYN=Y" // 목록 출력
//                +"&MobileOS=ETC&MobileApp=MatchUrKorea&_type=json"
//                +"&arrange=P" // 대표이미지가 반드시 있으면서 조회순으로 정렬
//                +"&numOfRows=12"
//                +"&pageNo=1";
//        URL url = new URL(urlstr);
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setRequestMethod("GET");
//        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
//        String returnLine;
//
//        while((returnLine=br.readLine()) != null){
//            result.append(returnLine+"\n\r");
//        }
//        urlConnection.disconnect();
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return result.toString();
//}

    @GetMapping(value= "/explore/character")
    public String exploreByCharacter(Model model) throws IOException, ParseException {
        List<Spot> list = spotService.parseResponse(spotService.callTourApi());
        model.addAttribute("spotList",list);
        return "characterSpot"; // TODO : html 파일 이름이랑 같이 변경
    }
}
