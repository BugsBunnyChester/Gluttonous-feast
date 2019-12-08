package com.bugsbunnywyunj.demo.entity;

import com.bugsbunnywyunj.demo.enums.ProductStatusEnum;
import com.bugsbunnywyunj.demo.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data//getset方法
//@DynamicUpdate//更新某个字段时更新所有字段
@Table(name = "Cart_product_list")
public class CartProductList implements Serializable {

    private static final long serialVersionUID = 6399186181668983148L;

    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;

    /** 名字. */
    @Column(name="product_name",length = 50)
    private String productName;

    /** 单价. */
    @Column(name="product_Price",length = 50)
    private BigDecimal productPrice;



    /** 描述. */
    @Column(name="product_Description",length = 50)
    private String productDescription;

    /** 小图. */
    @Column(name="product_Icon",length = 50)
    private String productIcon;
    @Column(name="Shop_Id",length =50)
    private  String shopId;
    @Column(name = "count",length = 50)
    private Integer count;
    @Column(name = "discount",length = 50)
    private  String discount;



    @Column(name="create_Time",length = 50)
    private Date createTime;
    @Column(name="update_Time",length = 50)
    private Date updateTime;




}
