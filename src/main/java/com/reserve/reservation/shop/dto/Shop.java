package com.reserve.reservation.shop.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    private String shopName;
    private String shopMasterName;
    private String shopAddress;
    private Integer emptyTable;

}
