package com.example.customer.repository;

import com.example.customer.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface customerRepository extends CrudRepository<Customer, Integer> {

}
