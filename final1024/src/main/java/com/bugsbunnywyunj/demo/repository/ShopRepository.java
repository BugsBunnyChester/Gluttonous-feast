package com.bugsbunnywyunj.demo.repository;

import com.bugsbunnywyunj.demo.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository <Shop,Integer> {
}
