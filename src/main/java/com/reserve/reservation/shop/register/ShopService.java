package com.reserve.reservation.shop.register;

import com.reserve.reservation.customer.dto.Customer;
import com.reserve.reservation.shop.dto.ReserveShop;
import com.reserve.reservation.shop.dto.Shop;
import com.reserve.reservation.shop.repository.ShopRepository;
import com.reserve.reservation.shopmaster.repository.ShopMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopMasterRepository shopMasterRepository;
    private final ShopRepository shopRepository;

    public Shop registerShop(Shop info) {
        return shopRepository.save(Shop.builder()
                .shopName(info.getShopName())
                .shopMasterName(info.getShopMasterName())
                .shopAddress(info.getShopAddress())
                .emptyTable(info.getEmptyTable()).build());
    }

    public Optional<?> searchShop (String shopName) {
        return shopRepository.findByShopName(shopName);
    }

    
}
