package com.reserve.reservation.shop.controller;

import com.reserve.reservation.exception.CustomException;
import com.reserve.reservation.exception.ErrorCode;
import com.reserve.reservation.shop.dto.Shop;
import com.reserve.reservation.shop.register.ShopService;
import com.reserve.reservation.shop.repository.ShopRepository;
import com.reserve.reservation.shopmaster.repository.ShopMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.reserve.reservation.exception.ErrorCode.USER_NOT_FOUND;
import static com.reserve.reservation.exception.ErrorCode.WRONG_NAME;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {
    private final ShopRepository shopRepository;
    private final ShopService shopService;
    private final ShopMasterRepository shopMasterRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerShop (@RequestBody Shop shop) {
        shopService.registerShop(shop);

        if (shop.getShopMasterName() == null) {
            throw new CustomException(USER_NOT_FOUND);
        }

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public Optional<?> searchShop (@RequestBody String shopName) {
        if (shopRepository.findByShopName(shopName).isEmpty()) {
            throw new CustomException(WRONG_NAME);
        }

        return shopRepository.findByShopName(shopName);
    }


}
