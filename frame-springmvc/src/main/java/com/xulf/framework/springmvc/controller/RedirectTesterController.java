package com.xulf.framework.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xuliufeng on 2016/1/8.
 */
@RequestMapping("/springmvc/redirect")
@Controller
public class RedirectTesterController {
    @RequestMapping("/beyondHost")
    public Object redirectAnotherDomain() {
        return "redirect:http://baidu.com";
    }
}
