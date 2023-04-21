package com.reserve.reservation.customer.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_Id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
}
