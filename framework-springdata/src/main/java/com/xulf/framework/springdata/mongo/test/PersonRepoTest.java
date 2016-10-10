package com.xulf.framework.springdata.mongo.test;


import com.xulf.framework.springdata.mongo.domain.Address;
import com.xulf.framework.springdata.mongo.domain.Person;
import com.xulf.framework.springdata.mongo.repo.AddressRepo;
import com.xulf.framework.springdata.mongo.repo.PersonRepo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PersonRepoTest {

    @Test
    public void save() {
        // retrieve personRepo
        ClassPathXmlApplicationContext context = getContext();
        PersonRepo personRepo = context.getBean(PersonRepo.class);

        // insert
        personRepo.deleteAll();
        personRepo.save(examplePerson());

        context.close();
    }


    @Test
    public void dbRef(){
        // retrieve personRepo
        ClassPathXmlApplicationContext context = getContext();
        PersonRepo personRepo = context.getBean(PersonRepo.class);
        AddressRepo addressRepo = context.getBean(AddressRepo.class);


        // save address
        Address address = new Address(1, "221b Baker Street", "London NW1", "London", 12345l);
        addressRepo.save(address);

        // save person: with dbRefed addresses
        Person person = new Person();
        person.setPersonId(21L);
        person.setName("Achilles");
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address);
        person.setAddresses(addresses);

        personRepo.deleteAll();
        personRepo.save(person);

        //retrieve
        Iterable<Person> persons = personRepo.findAll();
        for(Person p : persons) {
            System.out.println(p);
        }

        // close
        context.close();
    }

    private ClassPathXmlApplicationContext getContext() {
        return new ClassPathXmlApplicationContext(new ClassPathResource("springdata-mongo-config.xml").getPath());
    }

    private Person examplePerson() {
        Person person = new Person();
        person.setPersonId(1l);
        person.setName("Achilles");

        Map<String, String> others = new HashMap<String, String>();
        others.put("like_color", "blue");
        others.put("like_star", "Feymann");

        person.setOthers(others);
        return person;
    }
}
