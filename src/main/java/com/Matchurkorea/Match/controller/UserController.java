package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.User;
import com.Matchurkorea.Match.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUser() {
        return userService.getUserList();
    }
}
