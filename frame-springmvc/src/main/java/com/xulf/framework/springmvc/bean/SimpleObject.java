package com.xulf.framework.springmvc.bean;

/**
 * Created by xuliufeng on 2016/1/21.
 */
public class SimpleObject {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleObject{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
    }
}
