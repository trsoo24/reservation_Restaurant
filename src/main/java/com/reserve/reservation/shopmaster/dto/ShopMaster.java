package com.reserve.reservation.shopmaster.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long master_Id;
    private String name;
    private String email;
    private String password;
    private String shop_Name;

}
