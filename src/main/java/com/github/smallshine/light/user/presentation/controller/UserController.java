package com.github.smallshine.light.user.presentation.controller;

import com.github.smallshine.light.user.domain.model.User;
import com.github.smallshine.light.user.domain.service.UserService;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 * @author jarry
 * @date 2023-5-20
 */
@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    Gson gson;
    @Resource
    private UserService userService;

    @GetMapping("")
    public String index() {
        return "haha Welcome to light. This is user page! ";
    }

    @GetMapping("/")
    public String home() {
        return "This is user page! ";
    }

    @RequestMapping("test")
    public String test() {
        return "test page";
    }

    @GetMapping("/list")
    public String list() {
        User user = new User();
        user.setStatus(1);
        List<User> users = userService.getUserList(user);
        return gson.toJson(users);
    }

    @RequestMapping(value = "/{id}")
    public String getById(@PathVariable int id) {
        User user = userService.getUserById(id);
        Map map = new HashMap();
        map.put("code", 100);
        map.put("status", "success");
        map.put("data", user);
        return gson.toJson(map);
    }
}