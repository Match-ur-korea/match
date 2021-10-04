package com.Matchurkorea.Match.service;


import com.Matchurkorea.Match.domain.Spot;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface SpotService {
   String callTourApi(String characterCode, String areaCode) throws IOException;
   List<Spot> searchSpot(String keyword, int display, int start);
   List<Spot> findSpotByCharacter(String characterCode) throws IOException, ParseException;
   List<Spot> findSpotByArea(String areaCode) throws IOException, ParseException;
   List<Spot> findSpotByType(String characterCode, String areaCode) throws IOException, ParseException;
   List<Spot> parseResponse(String json) throws ParseException;
   JSONArray mergeJSONArrays(JSONArray... arrays);
   List<Spot> jsonToSpot(JSONArray item);

}