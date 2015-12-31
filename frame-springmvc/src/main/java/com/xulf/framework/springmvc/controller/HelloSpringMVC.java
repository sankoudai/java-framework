package com.xulf.framework.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuliufeng on 2015/12/31.
 */
@Controller
public class HelloSpringMVC {
    @RequestMapping("/hello/json")
    @ResponseBody
    public String testJson(String name) {
        if (name != null) {
            return String.format("hello, %s", name);
        }

        return "hello json!";
    }

    @RequestMapping("/hello/jsp")
    public String testJsp(){
        return "hello";
    }
}
