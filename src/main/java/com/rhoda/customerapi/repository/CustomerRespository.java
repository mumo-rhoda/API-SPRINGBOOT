package com.rhoda.customerapi.repository;

import com.rhoda.customerapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer,Integer> {

    Customer findByName(String name);
}
