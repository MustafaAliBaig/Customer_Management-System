package com.mustafa.customermanagement.service;

import com.mustafa.customermanagement.model.Customer;
import com.mustafa.customermanagement.repository.CustomerRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testFindAll(){
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setSubscriptionPlan("Premium");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        List<Customer> customers = customerService.findAll();
        assertEquals(1,customers.size());
        assertEquals("John Doe", customers.get(0).getName());
        verify(customerRepository,times(1)).findAll();


    }

}
