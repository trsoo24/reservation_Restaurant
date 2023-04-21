package com.reserve.reservation.shopmaster.repository;

import com.reserve.reservation.shopmaster.dto.ShopMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopMasterRepository extends JpaRepository<ShopMaster, Long> {
    Optional<ShopMaster> findById(Long id);
    Optional<ShopMaster> findByEmail(String email);
}
