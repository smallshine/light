package com.github.smallshine.light.user.presentation.controller;

import com.github.smallshine.light.base.controller.BaseController;
import com.github.smallshine.light.user.domain.model.User;
import com.github.smallshine.light.user.service.UserService;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 *
 * @author jarry
 * @date 2023-5-20
 */
@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Resource
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

    @GetMapping(value="/list", produces="application/json;charset=UTF-8")
    public String list() {
        User user = new User();
        user.setStatus(1);
        List<User> users = userService.getUserList(user);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "get user list success.");
        map.put("data", users);
        return getJSON(map);
    }

    @RequestMapping(value = "/{id}")
    public String getById(@PathVariable int id) {
        User user = userService.getUserById(id);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "get user id success.");
        map.put("data", user);
        return getJSON(map);
    }
}