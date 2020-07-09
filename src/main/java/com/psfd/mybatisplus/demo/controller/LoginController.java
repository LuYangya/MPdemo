package com.psfd.mybatisplus.demo.controller;

import com.psfd.mybatisplus.demo.bean.UserEntity;
import com.psfd.mybatisplus.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LuYang
 * @create 2020-07-05 19:29
 */
@Controller
public class LoginController {
    @Resource
    private IUserService userService;

    @RequestMapping("/login.do")
    public ModelAndView Login(String username, String password, HttpServletRequest httpServletRequest) {
        List<UserEntity> list = userService.list();
        ModelAndView mod = new ModelAndView();
        mod.setViewName("framework/error");
        for (UserEntity userEntity : list) {
            System.out.println(userEntity.getUsername() + "  " + userEntity.getPassword());
            if (userEntity.getUsername().equals(username) && userEntity.getPassword().equals(password)) {
                httpServletRequest.getSession().getServletContext().setAttribute("username", username);
                mod.setViewName("framework/manage");
            }
        }
        return mod;
    }

    @RequestMapping("/index")
    public String index(){
        return "framework/welcome";
    }
}
