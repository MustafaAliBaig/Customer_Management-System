package com.mustafa.customermanagement.repository;

import com.mustafa.customermanagement.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}