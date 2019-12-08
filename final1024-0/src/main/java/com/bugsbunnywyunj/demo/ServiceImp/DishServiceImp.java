package com.bugsbunnywyunj.demo.ServiceImp;

import com.bugsbunnywyunj.demo.entity.Dish;
import com.bugsbunnywyunj.demo.entity.User;
import com.bugsbunnywyunj.demo.repository.DishRepository;
import com.bugsbunnywyunj.demo.repository.UserRepository;
import com.bugsbunnywyunj.demo.service.DishService;
import com.bugsbunnywyunj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImp implements DishService {
    @Autowired
    private DishRepository dishRepository;
    @Override
    public List<Dish> getDishList() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findDishById(Integer id) {
        return dishRepository.findById((int) id).get();
    }

    @Override
    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void edit(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void delete(Integer id) {
        dishRepository.deleteById(id);
    }

}
