package com.bugsbunnywyunj.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "dish_info")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="dish_name",length = 50)
    private String dishName;
    @Column(name="dish_price",length = 50)
    private String dishPrice;
    @Column(name="dish_descrip",length = 50)
    private String dishDescrip;
    @Column(name="dish_deliver_time",length = 50)
    private String dishDeliverTime;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishDescrip() {
        return dishDescrip;
    }

    public void setDishDescrip(String dishDescrip) {
        this.dishDescrip = dishDescrip;
    }

    public String getDishDeliverTime() {
        return dishDeliverTime;
    }

    public void setDishDeliverTime(String dishDeliverTime) {
        this.dishDeliverTime = dishDeliverTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }






}
