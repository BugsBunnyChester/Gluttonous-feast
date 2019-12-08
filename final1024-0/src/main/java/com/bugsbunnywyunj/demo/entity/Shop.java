package com.bugsbunnywyunj.demo.entity;

import javax.persistence.*;
@Entity
@Table(name = "shop_info")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ShopId;
    @Column(name="shop_name",length = 50)
    private String shopName;
    @Column(name="shop_grade",length = 50)
    private String shopGrade;
    @Column(name="shop_descrip",length = 50)
    private String shopDexcrip;
    @Column(name="shop_herf",length = 50)
    private String shopHerf;
    @Column(name="shop_phone",length = 50)
    private String shopPhone;
    /*
    存储时在界面独立输入，获取后拼接存放
        将类别名称按  名称,id1,id2,id3,id4+名称,id1,id2+名称,id1,id2
        的形式存放在 classification字段中
        加载商店时字符串分割，按数组形式拿取以显示，和查询菜品信息
     */
    @Column(name="classification",length = 150)
    private String classification;

    public Integer getShopId() {
        return ShopId;
    }

    public void setShopId(Integer shopId) {
        ShopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopGrade() {
        return shopGrade;
    }

    public void setShopGrade(String shopGrade) {
        this.shopGrade = shopGrade;
    }

    public String getShopDexcrip() {
        return shopDexcrip;
    }

    public void setShopDexcrip(String shopDexcrip) {
        this.shopDexcrip = shopDexcrip;
    }

    public String getShopHerf() {
        return shopHerf;
    }

    public void setShopHerf(String shopHerf) {
        this.shopHerf = shopHerf;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
