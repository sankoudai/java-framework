package com.xulf.framework.springdata.mongo.repo;

import com.xulf.framework.springdata.mongo.domain.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {
    @Query("{'name' : ?0}")
    public Iterable<Person> searchByName(String personName);

}
