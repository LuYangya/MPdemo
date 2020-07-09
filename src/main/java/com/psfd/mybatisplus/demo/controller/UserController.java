package com.psfd.mybatisplus.demo.controller;

import com.psfd.mybatisplus.demo.bean.UserEntity;
import com.psfd.mybatisplus.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * @author LuYang
 * @create 2020-07-03 16:13
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;


    @RequestMapping("/getList")
    public ModelAndView getList(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("11111");
        List<UserEntity> list = userService.list();
        modelAndView.addObject("userlist",list);
        modelAndView.setViewName("framework/welcome");
        return modelAndView;
    }


    @RequestMapping("/listuser")
    public ModelAndView getlist(){
        List<UserEntity> list = userService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userlist",list);
        modelAndView.setViewName("user/listuser");

        return modelAndView;
    }
    @RequestMapping("/adduser")
    public void addUser(UserEntity user){
        Date date = new Date(System.currentTimeMillis());
        user.setCreatetime(date);
        System.out.println(user.toString());
        userService.save(user);
    }

    @RequestMapping("/remove.do")
    public ModelAndView remove(int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userlist",userService.list());
        userService.removeById(id);
        modelAndView.setViewName("user/listuser");
        return modelAndView;
    }


}
