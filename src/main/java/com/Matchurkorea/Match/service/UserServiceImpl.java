package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.User;
import com.Matchurkorea.Match.mapper.userMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final userMapper userMapper;

    @Override
    public List<User> getUserList() {
        return  userMapper.getUserList();
    }

    @Override
    public List<Character> getCharacterList(String s){
        String characterId=s;
        return userMapper.getCharacterList(characterId);
    }
}
