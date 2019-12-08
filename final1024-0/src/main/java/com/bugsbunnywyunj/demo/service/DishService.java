package com.bugsbunnywyunj.demo.service;

import com.bugsbunnywyunj.demo.entity.Dish;
import com.bugsbunnywyunj.demo.entity.User;

import java.util.List;

public interface DishService {
    public List<Dish> getDishList();

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Dish findDishById(Integer id);

    /**
     * 新增
     *
     * @param dish
     */
    public void save(Dish dish);

    /**
     * 修改
     *
     * @param dish
     */
    public void edit(Dish dish);

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id);
}
