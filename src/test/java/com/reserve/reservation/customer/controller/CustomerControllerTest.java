package com.reserve.reservation.customer.controller;

import com.reserve.reservation.customer.dto.Customer;
import com.reserve.reservation.customer.dto.CustomerSignUp;
import com.reserve.reservation.customer.repository.CustomerRepository;
import com.reserve.reservation.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void SignUp() {
        //given
        Customer customer = Customer.builder()
                .email("trsoo24@gmail.com")
                .password("1234")
                .name("박연준")
                .build();

        //when

        //then
        customerService.signUp(CustomerSignUp.builder()
                        .email(customer.getEmail())
                        .password(customer.getPassword())
                        .name(customer.getName())
                        .build());
    }

}