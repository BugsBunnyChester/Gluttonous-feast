package com.bugsbunnywyunj.demo.service;

import com.bugsbunnywyunj.demo.entity.ProductInfo;
import com.bugsbunnywyunj.demo.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ShopService {

    public List<Shop> getShopList();

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Shop findShopById(Integer id);
    public Page<Shop> findAll(Pageable pageable);

    /**
     * 新增
     *
     * @param shop
     */
    public void save(Shop shop);

    /**
     * 修改
     *
     * @param shop
     */
    public void edit(Shop shop);

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id);
}
