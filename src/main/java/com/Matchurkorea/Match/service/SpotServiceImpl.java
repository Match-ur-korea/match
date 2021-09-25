package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Spot;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpotServiceImpl implements SpotService{
    private static String clientID ="";
    @Value("${tourapi.key}")
    private String key;

    public String callTourApi() throws IOException {
        StringBuilder result = new StringBuilder();
        // Encoding된 키
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="+key
                    +"&contentTypeId="
                    +"&areaCode="
                    +"&sigunguCode="
                    +"&cat1=A01" //카테고리
                    +"&cat2=A0101"
                    +"&cat3=A01010700"
                    +"&listYN=Y" // 목록 출력
                    +"&MobileOS=ETC&MobileApp=MatchUrKorea&_type=json"
                    +"&arrange=P" // 대표이미지가 반드시 있으면서 조회순으로 정렬
                    +"&numOfRows=12"
                    +"&pageNo=1";
            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            String returnLine;

            while((returnLine=br.readLine()) != null){
                result.append(returnLine+"\n\r");
            }
            urlConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    public List<Spot> searchSpot(String keyword, int display, int start){
        List<Spot> list = null;
        return list;
    }
    public List<Spot> parseResponse(String json) throws ParseException {
        List<Spot> list = new ArrayList<Spot>();
        JSONParser parser = new JSONParser();
        Object object = (JSONObject) parser.parse(json);
        if (object instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject)object;
            JSONObject response = (JSONObject) jsonObject.get("response");
            JSONObject body = (JSONObject) response.get("body");
//            Long totalCount = (Long) body.get("totalCount");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray item = (JSONArray)items.get("item");
            for(Integer i=0; i < item.size(); i++)
            {
                JSONObject tourist_json = (JSONObject) item.get(i);
                Gson gson = new Gson();
                Spot spot = gson.fromJson(tourist_json.toString(),Spot.class);
                list.add(spot);
            }
        }
        return list;
    }
//    TODO : 여러 소분류 items 병합
//    public static JSONArray mergeJSONArrays{
//        return
//    }
}
