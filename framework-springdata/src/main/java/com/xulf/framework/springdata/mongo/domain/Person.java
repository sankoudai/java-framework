package com.xulf.framework.springdata.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document(collection = "person")
public class Person {
    @Id
    private String id;

    private Long personId;

    private String name;

    private int age;

    private Map<String, String> others;

    @DBRef(db = "address")
    private List<Address> addresses = new ArrayList<Address>();

    public Person() {
    }


    @PersistenceConstructor
    public Person(Long personId, String name, int age) {
        super();
        this.personId = personId;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

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

    public List<Address> getAddresses() {
        return addresses;
    }


    public void setAddresses(List<Address> addresses ) {
        this.addresses = addresses;
    }


    public Map<String, String> getOthers() {
        return others;
    }

    public void setOthers(Map<String, String> others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Person [personId=" + personId + ", name=" + name + ", age=" + age + ", addresses=" + addresses + "]";
    }


}
