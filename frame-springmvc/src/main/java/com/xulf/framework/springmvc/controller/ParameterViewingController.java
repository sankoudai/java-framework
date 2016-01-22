package com.xulf.framework.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuliufeng on 2016/1/21.
 */
@RequestMapping("/springmvc/param")
@Controller
public class ParameterViewingController {
    @RequestMapping("/resolve")
    public Object map(){
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", "jim");

        ModelAndView modelAndView = paramResolvingView();
        modelAndView.addObject("map", param);

        return modelAndView;
    }

    private ModelAndView paramResolvingView(){
        ModelAndView modelAndView = new ModelAndView("param_resolving");
        return modelAndView;
    }
}
