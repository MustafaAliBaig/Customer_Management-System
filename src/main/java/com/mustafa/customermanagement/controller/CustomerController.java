package com.mustafa.customermanagement.controller;

import com.mustafa.customermanagement.model.Customer;
import com.mustafa.customermanagement.model.Subscription;
import com.mustafa.customermanagement.service.CustomerService;
import com.mustafa.customermanagement.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return customerService.update(id, customer)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        if (customerService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/subscriptions")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.findAll();
    }

    @PostMapping("/subscriptions")
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.save(subscription);
    }

    @GetMapping("/subscriptions/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable String id) {
        return subscriptionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/subscriptions/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable String id, @RequestBody Subscription subscription) {
        return subscriptionService.update(id, subscription)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/subscriptions/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable String id) {
        if (subscriptionService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    // ✅ Public Hello endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, this is a public endpoint!";
    }
}