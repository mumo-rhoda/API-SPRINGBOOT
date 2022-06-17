package com.rhoda.customerapi.Service;

import com.rhoda.customerapi.model.Customer;
import com.rhoda.customerapi.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component

public class CustomerService {
    @Autowired

    private CustomerRespository customerRespository;

    public Customer addCustomer(Customer customer) {
        return customerRespository.save(customer);
    }


    public List<Customer> addAllCustomers(List<Customer> customers) {
        return customerRespository.saveAll(customers);
    }

    public Customer getCustomerByID(int id) {
        return customerRespository.findById(id).orElse(null);
    }

    public Customer getCustomerByName(String name) {
        return customerRespository.findByName(name);
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCust = customerRespository.findById(customer.getId()).orElse(null);
        if(existingCust == null){
            return customerRespository.save(customer);
        }else{
            customerRespository.deleteById(existingCust.getId());
            customerRespository.save(customer);
        }
        return customer;
    }

    public boolean deleteCustomerByID(int id) {
        Customer existingCust = customerRespository.getById(id);
        if (existingCust != null){
            customerRespository.deleteById(id);
         return true;
         }
        return false;
    }
}
