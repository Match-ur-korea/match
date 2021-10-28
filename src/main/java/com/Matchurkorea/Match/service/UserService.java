package com.Matchurkorea.Match.service;

import com.Matchurkorea.Match.domain.Character;
import com.Matchurkorea.Match.domain.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserService {
    public List<User> getUserList();
    public List<Character> getCharacterList(String s);
}
