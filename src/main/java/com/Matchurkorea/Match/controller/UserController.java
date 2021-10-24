package com.Matchurkorea.Match.controller;

import com.Matchurkorea.Match.domain.User.User;
import com.Matchurkorea.Match.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUser() {
        return userService.getUserList();
    }
}