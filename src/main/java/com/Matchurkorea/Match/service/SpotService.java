package com.Matchurkorea.Match.service;


import com.Matchurkorea.Match.domain.Spot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface SpotService {
   String callTourApi(String characterCode, String areaCode) throws IOException;
   List<Spot> searchSpot(String keyword, int display, int start);
   List<Spot> findSpotByCharacter(List<String> categories, int... pageNo) throws IOException, ParseException;
   List<Spot> findSpotByArea(String areaCode, int... pageNo) throws IOException, ParseException;
   List<Spot> findSpotByType(List<String> categories, String areaCode, int... pageNo) throws IOException, ParseException;
//   JSONObject getSpotOverview(String contentid) throws IOException;
   String getSpotOverview(String contentid) throws IOException;
   List<Spot> getSpotDetail(String contentid) throws IOException, ParseException;

   List<Spot> parseResponse(String json) throws ParseException;
   JSONArray mergeJSONArrays(List<JSONArray> arrays);
   List<Spot> jsonToSpot(JSONArray item);
   int getTotalCount(String json) throws ParseException;
   String getSpotImg(String contentid) throws IOException, ParseException;
   String  getSpotContent(String contentid)throws IOException, ParseException;
}
