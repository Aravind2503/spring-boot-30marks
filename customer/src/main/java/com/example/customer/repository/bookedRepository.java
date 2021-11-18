package com.example.customer.repository;

import com.example.customer.model.Booking;

import org.springframework.data.repository.CrudRepository;

// import java.util.*;

public interface bookedRepository extends CrudRepository<Booking, Integer> {
    Iterable<Booking> findBycustId(Integer custId);

}
