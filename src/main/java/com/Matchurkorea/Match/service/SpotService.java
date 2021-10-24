package com.Matchurkorea.Match.service;


import com.Matchurkorea.Match.domain.Spot;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SpotService {
   String callTourApi(String characterCode, String areaCode) throws IOException;
   List<Spot> searchSpot(String keyword, int display, int start);
   Map<Integer, List<Spot>> findSpotByCharacter(List<String> categories, int pageNo) throws IOException, ParseException;
   Map<Integer, List<Spot>> findSpotByArea(String areaCode, int pageNo) throws IOException, ParseException;
   Map<Integer, List<Spot>> findSpotByType(List<String> categories, String areaCode, int pageNo) throws IOException, ParseException;
//   JSONObject getSpotOverview(String contentid) throws IOException;
   String getSpotOverview(String contentid) throws IOException;
   List<Spot> getSpotDetail(String contentid) throws IOException, ParseException;

   Map<Integer, JSONArray> parseResponse(String json) throws ParseException;
   JSONArray mergeJSONArrays(List<JSONArray> arrays);
   List<Spot> jsonToSpot(JSONArray item);
}