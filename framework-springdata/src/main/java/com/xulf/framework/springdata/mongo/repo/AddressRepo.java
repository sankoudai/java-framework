package com.xulf.framework.springdata.mongo.repo;

import com.xulf.framework.springdata.mongo.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Long>
{
}
