package com.xulf.framework.hessian.service.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * @author : sankoudai
 * @version : created at 2015/10/10
 */
public class ExampleEntity implements Serializable{
    private String name;
    private int age;
    private boolean married;
    private double height;
    private Map<String, Object> otherInfo;
    private ExampleEntity mate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Map<String, Object> getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(Map<String, Object> otherInfo) {
        this.otherInfo = otherInfo;
    }

    public ExampleEntity getMate() {
        return mate;
    }

    public void setMate(ExampleEntity mate) {
        this.mate = mate;
    }

    @Override
    public String toString() {
        return "ExampleEntity{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        ", married=" + married +
                        ", height=" + height +
                        ", otherInfo=" + otherInfo +
                        ", mate=" + mate +
                        '}';
    }
}
