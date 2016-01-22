package com.xulf.framework.springmvc.controller;

import com.xulf.framework.springmvc.bean.CompositeObject;
import com.xulf.framework.springmvc.bean.SimpleObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xuliufeng on 2016/1/21.
 */
@RequestMapping("/springmvc/param")
@Controller
public class ParameterPassingController {

    @RequestMapping("/index")
    public Object index(){
        return "param_passing";
    }

    @RequestMapping("/simple")
    public Object simpleBean(SimpleObject simpleObject){
        return resultView(simpleObject);
    }

    @RequestMapping("/composite")
    public Object compositeBean(CompositeObject compositeObject){
        return resultView(compositeObject);
    }

    private ModelAndView resultView(Object result){
        String stringResult = result==null?"":result.toString();
        ModelAndView modelAndView = new ModelAndView("json_result");
        modelAndView.addObject("result", stringResult);
        return modelAndView;
    }
}
