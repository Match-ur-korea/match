package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Tour;
import com.Matchurkorea.Match.mapper.userMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService  {

    private final userMapper userMapper;

    @Override
    public void saveTour(String tour_id, String api_id, String user_id) {
        //TODO 중복 검사 & NULL 검사해서 통과하면 DB저장
        System.out.println("Before Save id : "+user_id);
        userMapper.saveTour(tour_id,api_id,user_id);
    }

    @Override
    public List<String> getTourList(String user_id){
        return userMapper.getTourList(user_id);
    }

    @Override
    public List<String> getTourContentId(String user_id, String tour_id){
        return userMapper.getTourContentId(user_id, tour_id);
    }

}
