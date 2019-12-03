package com.bugsbunnywyunj.demo.entity;

import com.bugsbunnywyunj.demo.enums.ProductStatusEnum;
import com.bugsbunnywyunj.demo.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data//getset方法
//@DynamicUpdate//更新某个字段时更新所有字段
@Table(name = "product_info")
public class ProductInfo implements Serializable {

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

    /** 库存. */
    @Column(name="product_Stock",length = 50)
    private Integer productStock;

    /** 描述. */
    @Column(name="product_Description",length = 50)
    private String productDescription;

    /** 小图. */
    @Column(name="product_Icon",length = 50)
    private String productIcon;
    @Column(name="Shop_Id",length =50)
    private  String shopId;

    /** 状态, 0正常1下架. */
    @Column(name="product_Status",length = 50)
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号. */
    @Column(name="category_Type",length = 50)
    private Integer categoryType;
    @Column(name="create_Time",length = 50)
    private Date createTime;
    @Column(name="update_Time",length = 50)
    private Date updateTime;

    /*@JsonIgnore
    json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
     */

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

    /**
     * 图片链接加host拼接成完整 url
     * @param host
     * @return
     */
    public ProductInfo addImageHost(String host) {
        if (productIcon.startsWith("//") || productIcon.startsWith("http")) {
            return this;
        }

        if (!host.startsWith("http")) {
            host = "//" + host;
        }
        if (!host.endsWith("/")) {
            host = host + "/";
        }
        productIcon = host + productIcon;
        return this;

    }
}
