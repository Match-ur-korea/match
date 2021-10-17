package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Spot;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SpotServiceImpl implements SpotService{
    private static String clientID ="";
    @Value("${tourapi.key}")
    private String key;

    public List<Spot>findSpotByCharacter(List<String> categories) throws IOException, ParseException {
    List<Spot> list = new ArrayList<Spot>();
    List<JSONArray> jsonArrays = new ArrayList<JSONArray>();
    System.out.println(categories);
    // Encoding 키
    for(String cat : categories){
        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="+key
                    +"&contentTypeId=12"
                    +"&areaCode="
                    +"&sigunguCode="
                    +"&cat1="+cat.substring(0,3) // 대분류
                    +"&cat2="+cat.substring(0,5) // 중분류
                    +"&cat3="+cat
                    +"&listYN=Y" // 목록 출력
                    +"&MobileOS=ETC&MobileApp=MatchUrKorea&_type=json"
                    +"&arrange=P"; // 대표이미지가 반드시 있으면서 조회순으로 정렬 ";
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

        jsonArrays.add(parseResponse(result.toString()));
    }
    // 가변 길이 잘 먹는지
    JSONArray merged = mergeJSONArrays(jsonArrays);
    list = jsonToSpot(merged);
    return list;
}
    public List<Spot> findSpotByArea(String areaCode) throws IOException, ParseException{
        List<Spot> list = new ArrayList<Spot>();
        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="+key
                    +"&contentTypeId=12"
                    +"&areaCode="+areaCode
                    +"&listYN=Y" // 목록 출력
                    +"&MobileOS=ETC&MobileApp=MatchUrKorea&_type=json"
                    +"&arrange=P"; // 대표이미지가 반드시 있으면서 조회순으로 정렬
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
        try {
            list = jsonToSpot((JSONArray) parseResponse(result.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Spot> findSpotByType(List<String> categories, String areaCode) throws IOException, ParseException {
        List<Spot> list = new ArrayList<Spot>();
        System.out.println(categories);
        List<JSONArray> jsonArrays = new ArrayList<JSONArray>();
        for(String cat : categories) {
            System.out.println(cat);
            StringBuilder result = new StringBuilder();
            try {
                String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key
                        + "&contentTypeId="
                        + "&areaCode=" + areaCode
                        + "&sigunguCode="
                        + "&cat1=" + cat.substring(0, 3) //카테고리
                        + "&cat2=" + cat.substring(0, 5)
                        + "&cat3=" + cat
                        + "&listYN=Y" // 목록 출력
                        + "&MobileOS=ETC&MobileApp=MatchUrKorea&_type=json"
                        + "&arrange=P"; // 대표이미지가 반드시 있으면서 조회순으로 정렬
                URL url = new URL(urlstr);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                String returnLine;

                while ((returnLine = br.readLine()) != null) {
                    result.append(returnLine + "\n\r");
                }
                urlConnection.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }
            jsonArrays.add(parseResponse(result.toString()));
        }
        // 가변 길이 잘 먹는지
        JSONArray merged = mergeJSONArrays(jsonArrays);
        list = jsonToSpot(merged);
        return list;
    }



    public List<Spot> getSpotDetail(String contentid) throws IOException, ParseException{
        List<Spot> list = new ArrayList<Spot>();
        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="+key
                    +"&contentId"+contentid
                    +"&defaultYN=Y"
                    +"&firstImageYN=Y"
                    +"&areacodeYN=Y"
                    +"&catcodeYN=Y" //카테고리
                    +"&addrinfoYN=Y"
                    +"&mapinfoYN=Y"
                    +"&overviewYN=Y"
                    +"&transGuideYN=Y"
                    +"&MobileOS=ETC&MobileApp=MatchUrKorea&_type=json";

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
        try {
            list = jsonToSpot((JSONArray) parseResponse(result.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public JSONObject getSpotOverview(String contentid) throws IOException {


        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?ServiceKey="+key
                    +"&contentId"+contentid
                    +"&defaultYN=Y"
                    +"&firstImageYN=Y"
                    +"&areacodeYN=Y"
                    +"&catcodeYN=Y" //카테고리
                    +"&addrinfoYN=Y"
                    +"&mapinfoYN=Y"
                    +"&overviewYN=Y"
                    +"&transGuideYN=Y"
                    +"&MobileOS=ETC&MobileApp=MatchUrKorea&_type=json";

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

        result.toString();
        System.out.println("detail"+result);
        JSONObject json = new JSONObject();
        json.put("data", result);
        return json;
    }

    public JSONArray parseResponse(String json) throws ParseException {
        JSONArray item = new JSONArray();
        JSONParser parser = new JSONParser();
        Object object = (JSONObject) parser.parse(json);
        System.out.println(object);
        if (object instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject)object;
            JSONObject response = (JSONObject) jsonObject.get("response");
            JSONObject body = (JSONObject) response.get("body");
            Long totalCount = (Long) body.get("totalCount");
            // 해당 카테고리에 맞는 여행지가 없는 경우
            if (totalCount == 0){
                return item;
            }else if(totalCount == 1){ // 해당 카테고리에 맞는 여행지가 하나만 있는 경우
                JSONObject items = (JSONObject) body.get("items");
                JSONObject oneitem = (JSONObject) items.get("item");
                item.add(oneitem);
                return item;
            }
            // 여행지가 2개 이상인 경우
            JSONObject items = (JSONObject) body.get("items");
            item = (JSONArray)items.get("item");
        }
        return item;
    }
    public JSONArray mergeJSONArrays(List<JSONArray> arrays){
        JSONArray newList = new JSONArray();
        for (JSONArray arr : arrays){
            newList.addAll(arr);
        }

        return newList;
    }
    public List<Spot> jsonToSpot(JSONArray item){
        List<Spot> list = new ArrayList<Spot>();
            for(Integer i=0; i < item.size(); i++)
            {
                JSONObject tourist_json = (JSONObject) item.get(i);
                Gson gson = new Gson();
                Spot spot = gson.fromJson(tourist_json.toString(),Spot.class);
                list.add(spot);
            }
        Collections.shuffle(list);
        return list;
    }
    public List<Spot> searchSpot(String keyword, int display, int start){
        List<Spot> list = null;
        return list;
    }

    public String callTourApi(String characterCode, String areaCode) throws IOException {
        StringBuilder result = new StringBuilder();
        // Encoding된 키
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="+key
                    +"&contentTypeId="
                    +"&areaCode="+areaCode
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
}
