package com.Matchurkorea.Match.service;


import com.Matchurkorea.Match.domain.Detail;
import com.Matchurkorea.Match.domain.Spot;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SpotService {
   Map<Integer, List<Spot>> findSpotByCharacter(List<String> categories, int pageNo) throws IOException, ParseException;
   Map<Integer, List<Spot>> findSpotByArea(String areaCode, int pageNo) throws IOException, ParseException;
   Map<Integer, List<Spot>> findSpotByType(List<String> categories, String areaCode, int pageNo) throws IOException, ParseException;
   Detail getSpotDetail(String contentid) throws IOException, ParseException;

   Map<Integer, JSONArray> parseResponse(String json) throws ParseException;
   JSONArray mergeJSONArrays(List<JSONArray> arrays);
   List<Spot> jsonToSpot(JSONArray item);
   Detail jsonToDetail(JSONArray item);
   String getSpotImg(String contentid) throws IOException, ParseException;
   String getSpotContent(String contentid)throws IOException, ParseException;

}