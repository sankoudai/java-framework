package com.xulf.framework.hessian.service.impl;

import com.caucho.hessian.server.HessianServlet;
import com.xulf.framework.hessian.service.HelloAPI;

/**
 * @author : sankoudai
 * @version : created at 2015/9/7
 */
public class HelloService extends HessianServlet implements HelloAPI {
    public String hello() {
        return "Hello world";
    }
}
