package com.psfd.mybatisplus.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LuYang
 * @create 2020-07-05 20:50
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/top")
    public String top(){
        return "framework/top";
    }

    @RequestMapping("/left")
    public String left(){
        return "framework/left";
    }
    @RequestMapping("/centre")
    public String center(){
        return "framework/mainfra";
    }

    @RequestMapping("/adduser")
    public String adduser(){
        return "user/adduser";
    }


    @RequestMapping("/addjob")
    public String addjob(){
        return "job/addjob";
    }
}
