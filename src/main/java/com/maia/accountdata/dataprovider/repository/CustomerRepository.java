package com.maia.accountdata.dataprovider.repository;

import com.maia.accountdata.dataprovider.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    @Query("{}")
    Set<CustomerEntity>findAllCustomer();

}
