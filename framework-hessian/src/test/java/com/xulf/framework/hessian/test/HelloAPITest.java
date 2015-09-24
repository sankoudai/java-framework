package com.xulf.framework.hessian.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.xulf.framework.hessian.service.HelloAPI;

import java.net.MalformedURLException;

/**
 * @author : sankoudai
 * @version : created at 2015/9/7
 */
public class HelloAPITest {
    public static void main(String[] args) throws MalformedURLException {
        HessianProxyFactory factory = new HessianProxyFactory();
        String url = "http://localhost:8080/hessian/hello";
        HelloAPI api = (HelloAPI)factory.create(HelloAPI.class, url);

        System.out.println(api.hello());
    }
}
