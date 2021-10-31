package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Tour;

import java.util.List;

public interface TourService {
    void saveTour(String tour_id,String api_id,String user_id);
    List<Tour> getTourList(String user_id);
    List<Tour> getTourInTheArea(String user_id,String tour_id);
}
