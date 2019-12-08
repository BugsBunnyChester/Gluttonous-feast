package com.bugsbunnywyunj.demo.repository;


import com.bugsbunnywyunj.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}