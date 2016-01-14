package com.xulf.framework.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xuliufeng on 2016/1/5.
 */
@Controller
public class InterceptedController {

    @RequestMapping("/interceptor/dispatch/test")
    public Object method() {
        return "index";
    }
}
