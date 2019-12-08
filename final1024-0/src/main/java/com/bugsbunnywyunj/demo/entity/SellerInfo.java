package com.bugsbunnywyunj.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Seller_info")
public class SellerInfo {

    @Id
    private String sellerId;
    @Column(name="user_name",length = 50)
    private String username;
    @Column(name="user_password",length = 50)
    private String password;
    @Column(name="openid",length = 50)
    private String openid;
}
