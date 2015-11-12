package com.xulf.framework.hessian.service.impl;

import com.caucho.hessian.server.HessianServlet;
import com.xulf.framework.hessian.service.HelloAPI;
import com.xulf.framework.hessian.service.entity.ExampleEntity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : sankoudai
 * @version : created at 2015/9/7
 */
public class HelloService extends HessianServlet implements HelloAPI {
    public String hello() {
        return "Hello world";
    }

    public ExampleEntity helloExample() {
        return example();
    }

    private ExampleEntity example(){
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setName("李雷");
        exampleEntity.setAge(27);
        exampleEntity.setHeight(1.75);
        exampleEntity.setMarried(true);

        Map<String, Object> otherInfo = new LinkedHashMap<String, Object>();
        otherInfo.put("education", "batchelor");
        exampleEntity.setOtherInfo(otherInfo);

        ExampleEntity mate = new ExampleEntity();
        mate.setName("Lucy");
        exampleEntity.setMate(mate);

        return exampleEntity;
    }
}
