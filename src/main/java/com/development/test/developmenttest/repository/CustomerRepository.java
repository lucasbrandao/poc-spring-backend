package com.development.test.developmenttest.repository;

import com.development.test.developmenttest.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {}
