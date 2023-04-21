package com.reserve.reservation.shopmaster.controller;

import com.reserve.reservation.exception.CustomException;
import com.reserve.reservation.shop.dto.Shop;
import com.reserve.reservation.shop.register.ShopService;
import com.reserve.reservation.shop.repository.ShopRepository;
import com.reserve.reservation.shopmaster.dto.ShopMaster;
import com.reserve.reservation.shopmaster.repository.ShopMasterRepository;
import com.reserve.reservation.shopmaster.service.ShopMasterService;
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
@RequestMapping("/shopmaster")
public class ShopMasterController {

    private final ShopMasterRepository shopMasterRepository;
    private final ShopRepository shopRepository;
    private final ShopService shopService;
    private final ShopMasterService service;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp (@RequestBody ShopMaster info) {
        if (service.signUp(info).equals("Success")) {
            return ResponseEntity.ok(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signin")
    public String SignIn (String email, String password) {
        Optional<ShopMaster> shopMaster = shopMasterRepository.findByEmail(email);
        if (shopMaster.get().getPassword().equals(password)) {
            return "로그인";
        } else {
            throw new CustomException(USER_NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public String registerShop (Long id, Shop shop) {
        Optional<ShopMaster> shopMaster = shopMasterRepository.findById(id);
        shopMaster.get().setShop_Name(shop.getShopName());
        shop.setShopMasterName(shopMaster.get().getName());

        return "Success";
    }

}
