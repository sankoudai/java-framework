package com.xulf.framework.mybatis.domain;

import java.util.Map;

/**
 * @author : sankoudai
 * @version : created at 2015/9/14
 */
public class ExampleEntity {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private Integer age;
    private String phone;
    private Map<String, String> extraDesc;

    /*---- getter && setter ----*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, String> getExtraDesc() {
        return extraDesc;
    }

    public void setExtraDesc(Map<String, String> extraDesc) {
        this.extraDesc = extraDesc;
    }

    @Override
    public String toString() {
        return "ExampleEntity{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", name='" + name + '\'' +
                        ", gender='" + gender + '\'' +
                        ", age=" + age +
                        ", phone='" + phone + '\'' +
                        ", extraDesc=" + extraDesc +
                        '}';
    }
}
