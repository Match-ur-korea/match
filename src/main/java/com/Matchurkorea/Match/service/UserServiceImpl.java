package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.User.User;
import com.Matchurkorea.Match.mapper.userMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final userMapper userMapper;

    @Override
    public List<User> getUserList() {
        return  userMapper.getUserList();
    }


    @Override
    public List<Character> getCharacterList(String characterId){
        return userMapper.getCharacterList(characterId);
    }

    @Override
    public List<Character> getCategoryList(String characterId) {
        return userMapper.getCategoryList(characterId);
    }

}