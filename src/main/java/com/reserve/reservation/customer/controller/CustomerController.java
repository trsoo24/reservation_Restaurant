package com.reserve.reservation.customer.controller;

import com.reserve.reservation.customer.dto.Customer;
import com.reserve.reservation.customer.dto.CustomerSignUp;
import com.reserve.reservation.customer.repository.CustomerRepository;
import com.reserve.reservation.customer.service.CustomerService;
import com.reserve.reservation.exception.CustomException;
import com.reserve.reservation.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.reserve.reservation.exception.ErrorCode.USER_NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<?> SignUp (@RequestBody CustomerSignUp info) {
        if (customerService.signUp(info).equals("Success")) {
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signin")
    public String SignIn (String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.get().getPassword().equals(password)) {
            return "로그인";
        } else {
            throw new CustomException(USER_NOT_FOUND);
        }
    }
}
