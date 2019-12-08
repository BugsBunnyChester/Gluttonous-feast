package com.bugsbunnywyunj.demo.repository;

import com.bugsbunnywyunj.demo.entity.Dish;

import com.bugsbunnywyunj.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository <Dish,Integer>{
}
