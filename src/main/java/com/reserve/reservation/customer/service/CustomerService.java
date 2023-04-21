package com.reserve.reservation.customer.service;

import com.reserve.reservation.customer.dto.Customer;
import com.reserve.reservation.customer.dto.CustomerSignUp;
import com.reserve.reservation.customer.repository.CustomerRepository;
import com.reserve.reservation.shop.dto.Shop;
import com.reserve.reservation.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public String signUp (CustomerSignUp info) {
        customerRepository.save(Customer.builder()
                        .email(info.getEmail())
                        .password(info.getPassword())
                        .name(info.getName())
                        .build());

        return "Success";
    }

}
