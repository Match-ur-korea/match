package com.Matchurkorea.Match.mapper;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {
    List<User> getUserList();
    List<Character> getCharacterList(String characterId);
    List<Character> getCategoryList(String characterId);
}
