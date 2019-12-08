package com.bugsbunnywyunj.demo.repository;

import com.bugsbunnywyunj.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer>{
    User findByPhone(String phone);
}
