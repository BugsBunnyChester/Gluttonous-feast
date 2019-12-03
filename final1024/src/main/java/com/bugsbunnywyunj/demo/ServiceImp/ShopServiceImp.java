package com.bugsbunnywyunj.demo.ServiceImp;

import com.bugsbunnywyunj.demo.entity.ProductInfo;
import com.bugsbunnywyunj.demo.entity.Shop;
import com.bugsbunnywyunj.demo.repository.ShopRepository;
import com.bugsbunnywyunj.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImp implements ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<Shop> getShopList() {
        return shopRepository.findAll();
    }

    @Override
    public Page<Shop> findAll(Pageable pageable) {
        Page<Shop> shopInfoPage=shopRepository.findAll(pageable);
        return shopInfoPage;
    }

    @Override
    public Shop findShopById(Integer id) {
        return shopRepository.findById((int) id).get();
    }

    @Override
    public void save(Shop shop) {
        shopRepository.save(shop);

    }

    @Override
    public void edit(Shop shop) {
        shopRepository.save(shop);

    }

    @Override
    public void delete(Integer id) {
        shopRepository.deleteById(id);

    }
}
