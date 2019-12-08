package com.bugsbunnywyunj.demo.entity;
import javax.persistence.*;
@Entity
@Table(name = "Order_info")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="custom_name",length = 50)
    private String cstomName;
    @Column(name="custom_Id",length = 50)
    private String cstomId;
    @Column(name="Order_price",length = 50)
    private String OrderPrice;
    @Column(name="shop_name",length = 50)
    private String shopName;
    @Column(name="shop_id",length = 50)
    private String shopId;
    @Column(name="transaction_time",length = 50)
    private String trannsactionTime;


    @Column(name="dishs_ids",length = 50)
    private String DishsIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCstomName() {
        return cstomName;
    }

    public void setCstomName(String cstomName) {
        this.cstomName = cstomName;
    }

    public String getCstomId() {
        return cstomId;
    }

    public void setCstomId(String cstomId) {
        this.cstomId = cstomId;
    }

    public String getOrderPrice() {
        return OrderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        OrderPrice = orderPrice;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTrannsactionTime() {
        return trannsactionTime;
    }

    public void setTrannsactionTime(String trannsactionTime) {
        this.trannsactionTime = trannsactionTime;
    }

    public String getDishsIds() {
        return DishsIds;
    }

    public void setDishsIds(String dishsIds) {
        DishsIds = dishsIds;
    }
}
