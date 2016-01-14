package com.xulf.framework.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuliufeng on 2015/12/31.
 */
@RequestMapping("/springmvc/requestmapping")
@Controller
public class RequestMappingTester {
    @ResponseBody
    @RequestMapping(value = "/params", params = {"method=param1"})
    public Object testParams1(){
        return "param1";
    }

    @ResponseBody
    @RequestMapping(value = "/params", params = {"method=param2"})
    public Object testParams2(){
        return "param2";
    }
}
