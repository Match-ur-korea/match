package com.Matchurkorea.Match.service;


import com.Matchurkorea.Match.domain.Spot;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface SpotService {
   List<Spot> searchSpot(String keyword, int display, int start);
   String callTourApi() throws IOException;
   List<Spot> parseResponse(String json) throws ParseException;

}
