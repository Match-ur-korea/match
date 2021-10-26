package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.mapper.userMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService  {

    private final userMapper userMapper;

    @Override
    public void saveTour(String tour_id, String api_id, String user_id) {
        //TODO 중복 검사 & NULL 검사해서 통과하면 DB저장
        userMapper.saveTour(tour_id,api_id,user_id);
    }


}
