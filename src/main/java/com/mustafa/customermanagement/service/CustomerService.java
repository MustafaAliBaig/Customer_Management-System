package com.mustafa.customermanagement.service;

import com.mustafa.customermanagement.model.Customer;
import com.mustafa.customermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> update(String id, Customer customer) {
        return customerRepository.findById(id).map(existing -> {
            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
            existing.setSubscriptionPlan(customer.getSubscriptionPlan());
            return customerRepository.save(existing);
        });
    }

    public boolean delete(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}