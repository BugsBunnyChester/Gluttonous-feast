package com.bugsbunnywyunj.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
@Table(name = "Product_Category_info")
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    @Column(name="category_name",length = 50)
    private String categoryName;

    /** 类目编号. */
    @Column(name="category_Type",length = 50)
    private Integer categoryType;
    @Column(name="category_Time",length = 50)
    private Date createTime;
    @Column(name="update_Time",length = 50)
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.createTime=createTime;
        this.updateTime=updateTime;
    }
}
