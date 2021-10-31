package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.User.User;


import java.util.List;

public interface UserService {
    List<User> getUserList();
    List<Character> getAllCharacterList();
    Character getCharacterList(String characterId);
    List<Character> getCategoryList(String characterId);

    void saveCharacter(String user_id, String selectId);
    String getUserCharacter(String user_id);

}