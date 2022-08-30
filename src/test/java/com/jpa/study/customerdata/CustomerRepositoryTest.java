package com.jpa.study.customerdata;

import com.jpa.study.customerdata.domain.entity.Customer;
import com.jpa.study.customerdata.domain.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void create(){
        Customer customer = new Customer("Ze", "ze@email.test");
        Assertions.assertEquals(customer, customerRepository.save(customer));
    }

    @Test
    void update(){
        Customer customer = customerRepository.findById(1L).get();
        customer.setEmail("newemail");
        Assertions.assertEquals(customer, customerRepository.save(customer));
    }

    @Test
    void delete(){
        customerRepository.deleteById(2L);
        Assertions.assertFalse(customerRepository.existsById(2L));
    }
}
