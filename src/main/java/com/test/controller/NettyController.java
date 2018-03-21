package com.test.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/send")
public class NettyController {
    @RequestMapping("/1")
    public ModelAndView netty(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        Object o = request.getSession().getAttribute("userName");
        map.put("userName",o);
        return new ModelAndView("netty");
    }

    @RequestMapping("getClient")
    public String getName(HttpServletRequest request){
        return request.getSession().getAttribute("userName").toString();
    }

    @RequestMapping("/2")
    public ModelAndView netty2(){
        return new ModelAndView("netty2");
    }

    @RequestMapping("3")
    public ModelAndView netty3(){
        return new ModelAndView("netty3");
    }
}
