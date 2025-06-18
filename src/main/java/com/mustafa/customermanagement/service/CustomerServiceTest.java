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
import java.util.Optional;

import static org.junit.Assert.*;
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

    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("John Doe");
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer saved=customerService.save(customer);
        assertNotNull(saved);
        assertEquals("John Doe", saved.getName());
        verify(customerRepository,times(1)).save(customer);
    }

    @Test
    public void testUpdate(){
        Customer existing=new Customer();
        existing.setId("1");
        existing.setName("Old Name");
        Customer updated= new Customer();
        updated.setName("New Name");
        updated.setEmail("new@example.com");
        when(customerRepository.findById("1")).thenReturn(Optional.of(existing));
        when(customerRepository.save(any(Customer.class))).thenReturn(updated);
        Optional<Customer> result=customerService.update("1", updated);
        assertTrue(result.isPresent());
        assertEquals("New Name", result.get().getName());
        verify(customerRepository,times(1)).findById("1");
        verify(customerRepository,times(1)).save(any(Customer.class));

    }

    @Test
    public void testDelete(){
        when(customerRepository.existsById("1")).thenReturn(true);
        doNothing().when(customerRepository).deleteById("1");
        boolean deleted= customerService.delete("1");
        assertTrue(deleted);
        verify(customerRepository, times(1)).existsById("1");
        verify(customerRepository,times(1)).deleteById("1");
    }
}
