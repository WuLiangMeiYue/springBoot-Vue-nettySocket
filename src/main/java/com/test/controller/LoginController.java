package com.test.controller;

import com.test.entity.Product;
import com.test.service.ProductService;
import com.test.service.UserService;
import com.test.vo.User_vo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public ModelAndView welcome(){
        return new ModelAndView("login");
    }

    @RequestMapping("toLogin")
    public ModelAndView toLogin() throws IOException {
        return new ModelAndView("login");
    }
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @Param("user_vo")User_vo user_vo) throws IOException {
        Map<String, Object> map = new HashMap<>();
        boolean message = userService.login(user_vo);
        if (!message){
            map.put("message","登录失败，请检查用户名和密码");
            return new ModelAndView("login",map);
        }
        request.getSession().setAttribute("userName",user_vo.getUserName());
        response.sendRedirect("toIndex");
        return this.toIndex();
    }

    @RequestMapping("toIndex")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Product> listTable(HttpServletRequest request){
        List<Product> list = productService.finAll();
        return list;
    }

    @RequestMapping("toRegist")
    public ModelAndView toRegist(){
        return new ModelAndView("regist");
    }

    @RequestMapping("regist")
    public ModelAndView regist(@Param("user_vo")User_vo user_vo){
        userService.regist(user_vo);
        return toIndex();
    }

    @RequestMapping("toAdd")
    public ModelAndView toAdd(){
        return new ModelAndView("add");
    }

}

