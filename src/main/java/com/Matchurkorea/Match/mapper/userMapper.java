package com.Matchurkorea.Match.mapper;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.Tour;
import com.Matchurkorea.Match.domain.User.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface userMapper {
    List<User> getUserList();
    List<Character> getCharacterList(String characterId);
    List<Character> getCategoryList(String characterId);
    //로그인 & 회원가입
    User findByEmail(String email);
    void save(User user);
    void saveTour(@Param("tour_id") String tour_id,@Param("api_id") String api_id,@Param("user_id") String user_id);

    List<Character> getAllCharacterList();

    void saveCharacter(@Param("user_id") String user_id, @Param("selectId") String selectId);

    String getUserCharacter(@Param("user_id") String user_id);

    int checkName(@Param("user_id") String user_id);

    void updateCharacter(@Param("user_id") String user_id, @Param("selectId") String selectId);
    // 나의 여행보기
    // 사용자별 여행지역 목록
    List<Tour> getTourList(String user_id);
    // 사용자별, 지역별 여행지 목록
    List<Tour> getTourInTheArea(@Param("user_id") String user_id, @Param("tour_id") String tour_id);
}