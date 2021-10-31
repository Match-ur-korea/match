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
    public List<Character> getAllCharacterList() {
        return userMapper.getAllCharacterList();
    }

    @Override
    public List<Character> getCharacterList(String characterId){
        return userMapper.getCharacterList(characterId);
    }

    @Override
    public List<Character> getCategoryList(String characterId) {
        return userMapper.getCategoryList(characterId);
    }

    @Override
    public void saveCharacter(String user_id,String selectId) {
        if(userMapper.checkName(user_id)!=1)
            userMapper.saveCharacter(user_id,selectId);
        else
            userMapper.updateCharacter(user_id,selectId);
    }

    @Override
    public String getUserCharacter(String user_id) {
        return userMapper.getUserCharacter(user_id);
    }

}
