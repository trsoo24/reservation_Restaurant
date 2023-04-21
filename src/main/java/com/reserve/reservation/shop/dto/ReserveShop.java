package com.reserve.reservation.shop.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class ReserveShop {
    private String customerName;
    private String customerPhone;
    private int howManyPeople;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime reservedTime;

    public static ReserveShop reservation (ReserveShop reserveShop) {
        return reserveShop.builder()
                .customerName(reserveShop.getCustomerName())
                .customerPhone(reserveShop.getCustomerPhone())
                .howManyPeople(reserveShop.getHowManyPeople())
                .reservedTime(reserveShop.getReservedTime())
                .build();
    }
}
