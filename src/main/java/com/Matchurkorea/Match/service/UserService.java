package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.User;


import java.util.List;

public interface UserService {
    List<User> getUserList();
    List<Character> getCharacterList(String s);
    List<Character> getCategoryList(String characterId);
}
