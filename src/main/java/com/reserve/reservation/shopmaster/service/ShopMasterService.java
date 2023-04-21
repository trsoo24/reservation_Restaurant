package com.reserve.reservation.shopmaster.service;

import com.reserve.reservation.exception.CustomException;
import com.reserve.reservation.shop.dto.Shop;
import com.reserve.reservation.shop.repository.ShopRepository;
import com.reserve.reservation.shopmaster.dto.ShopMaster;
import com.reserve.reservation.shopmaster.repository.ShopMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.reserve.reservation.exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ShopMasterService {

    private final ShopMasterRepository shopMasterRepository;
    private final ShopRepository shopRepository;

    public String signUp (ShopMaster info) {
        ShopMaster shopMaster = ShopMaster.builder()
                                            .master_Id(info.getMaster_Id())
                                            .email(info.getEmail())
                                            .name(info.getName())
                                            .password(info.getPassword())
                                            .build();

        shopMasterRepository.save(shopMaster);

        return "Success";
    }

    public String registerShop (Long id, Shop shop) {
        ShopMaster shopMaster = shopMasterRepository.findById(id)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));

        shopMaster.setShop_Name(shop.getShopName());

        return "Success";
    }
}
