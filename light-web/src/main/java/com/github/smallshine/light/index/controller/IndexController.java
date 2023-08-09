package com.github.smallshine.light.index.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页控制器
 * @author jarry
 * @date 2023-5-20
 */

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("")
    public String index() {
        return "Welcome to Light Project. This is Homepage! ";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!Welcome to Light Project.";
    }

    @GetMapping("/hello-world")
    public ModelAndView helloWorld() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello-world");
        modelAndView.addObject("title", "Thymeleaf 使用");
        modelAndView.addObject("desc", "Spring Boot 整合 Thymeleaf");
        return modelAndView;
    }
}