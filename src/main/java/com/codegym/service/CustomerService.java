package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Customer save(Customer model) throws Exception {
        if (true)
            throw new Exception("save error");
        return customerRepository.save(model);
    }
}
