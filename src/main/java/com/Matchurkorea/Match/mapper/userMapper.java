package com.Matchurkorea.Match.mapper;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.User.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface userMapper {
    List<User> getUserList();
    List<Character> getCharacterList(String characterId);
    List<Character> getAllCharacterList();
    List<Character> getCategoryList(String characterId);
    //로그인 & 회원가입
    User findByEmail(String email);
    void save(User user);
    void saveTour(@Param("tour_id") String tour_id,@Param("api_id") String api_id,@Param("user_id") String user_id);
}