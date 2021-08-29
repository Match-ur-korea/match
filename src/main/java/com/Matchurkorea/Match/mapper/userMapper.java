package com.Matchurkorea.Match.mapper;

import com.Matchurkorea.Match.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {
    List<User> getUserList();
}
