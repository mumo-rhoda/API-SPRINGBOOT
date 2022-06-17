package com.rhoda.customerapi.controller;


import com.rhoda.customerapi.model.Customer;
import com.rhoda.customerapi.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cust")
public class CustomerController {
@Autowired
    private CustomerService customerService;
//Add new customer
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
       return customerService.addCustomer(customer);

    }

    // Add more than 1 customer
    @PostMapping("/addCustomers")
    public List<Customer>addAllCustomers(@RequestBody List<Customer> customers){
        return customerService.addAllCustomers(customers);
    }
    //Get customer ny Id
    @GetMapping("/getCustomerByID")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerByID(id);
    }
    //Get customer by name
    @GetMapping("/getCustomerByName/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }
    //update customer
    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    //Delete customer
    @DeleteMapping("/delete-CustomerById/{id}")
    public boolean deleteCustomerByID(@PathVariable int id){
        return customerService.deleteCustomerByID(id);
    }
}
