package com.bugsbunnywyunj.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Order_info")
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单id. */
    @Column(name="order_Id",length = 50)
    private String orderId;

    /** 商品id. */
    @Column(name="product_Id",length = 50)
    private String productId;

    /** 商品名称. */
    @Column(name="product_name",length = 50)
    private String productName;

    /** 商品单价. */
    @Column(name="product_Price",length = 50)
    private BigDecimal productPrice;

    /** 商品数量. */
    @Column(name="product_Quantity",length = 50)
    private Integer productQuantity;

    /** 商品小图. */
    @Column(name="product_Icon",length = 50)
    private String productIcon;
}
