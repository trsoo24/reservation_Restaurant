package com.reserve.reservation.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopDto {

    String shop_Name;
    String shop_MasterName;
    String shop_Address;
    Integer empty_Table;

    public static ShopDto info (Shop shop) {
        return ShopDto.builder()
                .shop_Name(shop.getShopName())
                .shop_MasterName(shop.getShopMasterName())
                .shop_Address(shop.getShopAddress())
                .build();
    }
}
