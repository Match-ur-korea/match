package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Detail;
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
import java.util.*;

@Service
public class SpotServiceImpl implements SpotService{
    @Value("${tourapi.key}")
    private String key;

    public Map<Integer, List<Spot>> findSpotByCharacter(List<String> categories, int pageNo) throws IOException, ParseException {
    Map<Integer, List<Spot>> map = new HashMap<Integer, List<Spot>>();
    int totalCount = 0;
    List<Spot> list = new ArrayList<Spot>();
    List<JSONArray> jsonArrays = new ArrayList<JSONArray>();
    for(String cat : categories){
        Map<Integer, JSONArray> temp = new HashMap<Integer, JSONArray>();
        JSONArray jsonArray = new JSONArray();
        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="+key
                    +"&contentTypeId=12"
                    +"&areaCode="
                    +"&sigunguCode="
                    +"&cat1="+cat.substring(0,3) // 대분류
                    +"&cat2="+cat.substring(0,5) // 중분류
                    +"&cat3="+cat
                    +"&numOfRows=15"
                    +"&pageNo="+Integer.toString(pageNo)
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
        temp = parseResponse(result.toString());
        for (Map.Entry<Integer, JSONArray> elem : temp.entrySet()){
            totalCount += elem.getKey().intValue();
            jsonArray = elem.getValue();
        }
        jsonArrays.add(jsonArray);
    }

    JSONArray merged = mergeJSONArrays(jsonArrays);
    list = jsonToSpot(merged);
    map.put(totalCount, list);
    return map;
}
    public Map<Integer, List<Spot>> findSpotByArea(String areaCode, int pageNo) throws IOException, ParseException{
//        int pageNum = pageNo.length>0?pageNo[0]:1;
        Map<Integer, List<Spot>> map = new HashMap<Integer, List<Spot>>();
        int totalCount = 0;
        List<Spot> list = new ArrayList<Spot>();
        JSONArray jsonArray = new JSONArray();
        Map<Integer, JSONArray> temp = new HashMap<Integer, JSONArray>();
        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="+key
                    +"&contentTypeId=12"
                    +"&areaCode="+areaCode
                    +"&numOfRows=15"
                    +"&pageNo="+Integer.toString(pageNo)
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
            temp = parseResponse(result.toString());
            for (Map.Entry<Integer, JSONArray> elem : temp.entrySet()){
                totalCount += elem.getKey().intValue();
                jsonArray = elem.getValue();
            }
            list = jsonToSpot(jsonArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put(totalCount, list);
        return map;
    }
    public Map<Integer, List<Spot>> findSpotByType(List<String> categories, String areaCode, int pageNo) throws IOException, ParseException {
        Map<Integer, List<Spot>> map = new HashMap<Integer, List<Spot>>();
        int totalCount = 0;
        List<Spot> list = new ArrayList<Spot>();
        List<JSONArray> jsonArrays = new ArrayList<JSONArray>();
        for(String cat : categories) {
            Map<Integer, JSONArray> temp = new HashMap<Integer, JSONArray>();
            JSONArray jsonArray = new JSONArray();

            StringBuilder result = new StringBuilder();
            try {
                String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key
                        + "&contentTypeId=12"
                        + "&areaCode=" + areaCode
                        + "&sigunguCode="
                        + "&cat1=" + cat.substring(0, 3) //카테고리
                        + "&cat2=" + cat.substring(0, 5)
                        + "&cat3=" + cat
                        +"&numOfRows=15"
                        +"&pageNo="+Integer.toString(pageNo)
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
            temp = parseResponse(result.toString());
            for (Map.Entry<Integer, JSONArray> elem : temp.entrySet()){
                totalCount += elem.getKey().intValue();
                jsonArray = elem.getValue();

            }
            jsonArrays.add(jsonArray);
        }

        JSONArray merged = mergeJSONArrays(jsonArrays);
        list = jsonToSpot(merged);
        map.put(totalCount, list);
        return map;
    }


    public Detail getSpotDetail(String contentid) throws IOException, ParseException{
        Detail detail = new Detail();
        int totalCount = 0;
        JSONArray jsonArray = new JSONArray();
        Map<Integer, JSONArray> temp = new HashMap<Integer, JSONArray>();
        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="+key
                    +"&contentId="+contentid
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
            temp = parseResponse(result.toString());
            for (Map.Entry<Integer, JSONArray> elem : temp.entrySet()){
                totalCount += elem.getKey().intValue();
                jsonArray = elem.getValue();
            }
            detail = jsonToDetail(jsonArray);
            return detail;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Override
    public Map<Integer, JSONArray> parseResponse(String json) throws ParseException {
        Map<Integer, JSONArray> result = new HashMap<Integer, JSONArray>();
        JSONArray item = new JSONArray();
        JSONParser parser = new JSONParser();
        Object object = (JSONObject) parser.parse(json);
        if (object instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject)object;
            JSONObject response = (JSONObject) jsonObject.get("response");
            JSONObject body = (JSONObject) response.get("body");
            int totalCount = Integer.parseInt(String.valueOf(body.get("totalCount")));
            // 해당 카테고리에 맞는 여행지가 없는 경우 -> <0, null> 반환
            if(totalCount == 0){
                result.put(totalCount, item);
                return result;
            }else if(totalCount == 1){ // 해당 카테고리에 맞는 여행지가 하나만 있는 경우
                JSONObject items = (JSONObject) body.get("items");
                JSONObject oneitem = (JSONObject) items.get("item");
                item.add(oneitem);
            }else{
                // 여행지가 2개 이상인 경우
                JSONObject items = (JSONObject) body.get("items");
                item = (JSONArray)items.get("item");
            }
            result.put(totalCount, item);

        }
        return result;
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
            JSONObject touristJson = (JSONObject) item.get(i);
            Gson gson = new Gson();
            Spot spot = gson.fromJson(touristJson.toString(),Spot.class);
            if (spot.getFirstimage()==null) {
                continue;
            }else{
            list.add(spot);
            }
        }
        Collections.shuffle(list);
        return list;
    }
    public Detail jsonToDetail(JSONArray item){
        JSONObject detailJson = (JSONObject) item.get(0);
        Gson gson = new Gson();
        Detail detail = gson.fromJson(detailJson.toString(), Detail.class);
        return detail;
    }

    public String getSpotContent(String contentid) throws IOException, ParseException{
        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="+key
                    +"&contentId="+contentid
                    +"&defaultYN=Y"
                    +"&firstImageYN=Y"
                    +"&areacodeYN=Y"
                    +"&catcodeYN=Y" //카테고리
                    +"&addrinfoYN=Y"
                    +"&mapinfoYN=Y"
                    +"&overviewYN=Y"
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
        JSONParser parser=new JSONParser();
        Object obj=(JSONObject)parser.parse(result.toString());


        JSONObject jsonObject=(JSONObject) obj;
        JSONObject response = (JSONObject) jsonObject.get("response");
        JSONObject body = (JSONObject) response.get("body");

        JSONObject items= (JSONObject) body.get("items");
        JSONObject item= (JSONObject) items.get("item");
        String content= (String) item.get("overview");
        return content;
    }

    public String getSpotImg(String contentid) throws IOException, ParseException{
        if(contentid=="")
            return "";
        StringBuilder result = new StringBuilder();
        try{
            String urlstr ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="+key
                    +"&contentId="+contentid
                    +"&firstImageYN=Y"
                    +"&defaultYN=Y"
                    +"&MobileOS=ETC"
                    +"&MobileApp=MatchUrKorea&_type=json";
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
        JSONParser parser=new JSONParser();
        Object obj=(JSONObject)parser.parse(result.toString());
        JSONObject jsonObject=(JSONObject) obj;
        JSONObject response = (JSONObject) jsonObject.get("response");
        JSONObject body = (JSONObject) response.get("body");

        JSONObject items= (JSONObject) body.get("items");
        JSONObject item= (JSONObject) items.get("item");
        String add = (String) item.get("firstimage");
        return add;

    }

}