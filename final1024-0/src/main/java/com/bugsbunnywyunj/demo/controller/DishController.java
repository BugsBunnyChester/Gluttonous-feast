package com.bugsbunnywyunj.demo.controller;

import com.bugsbunnywyunj.demo.entity.Dish;
import com.bugsbunnywyunj.demo.entity.User;
import com.bugsbunnywyunj.demo.repository.DishRepository;
import com.bugsbunnywyunj.demo.repository.UserRepository;
import com.bugsbunnywyunj.demo.service.DishService;
import com.bugsbunnywyunj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class DishController {
    @Resource
    private DishService dishService;

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/Dish/{id}")
    @ResponseBody
    public Dish getDish(@PathVariable("id")Integer id)
    {
        Dish dish= dishRepository.findById(id).get();
        return dish;
    }
    @GetMapping("/Dish")
    @ResponseBody
    public Dish insterDish(Dish dish){
        Dish save=dishRepository.save(dish);
        return save;
    }



    @RequestMapping("/Dishlist")
    public String lsit(Model model){
        List<Dish> dishs = dishService.getDishList();
        model.addAttribute("Dishs",dishs);
        return "Dish/DishList";
    }

    @RequestMapping("/toAddDish")
    public String toadd(Dish dish){
        return "Dish/DishAdd";//跳转到DishAdd.html
    }

    @RequestMapping("/addDish")
    public String add(Dish dish, @RequestParam("DishName") String Dishname
            , @RequestParam("DishPrice") String DishPrice
            , @RequestParam("DishDescrib") String DishDescrib
            , @RequestParam("DeliveryTime") String DeliveryTime
            , Map<String,Object> map, HttpSession sessio){
        if(Dishname.isEmpty())
        {
            map.put("msg", "输入姓名为空");
            System.out.println("输入为空");
            return "Dish/DishAdd";
        }else {
            dish.setDishName(Dishname);
            dish.setDishDeliverTime(DeliveryTime);
            dish.setDishDescrip(DishDescrib);
            dish.setDishPrice(DishPrice);

            dishService.save(dish);
            return "redirect:/Dishlist";//添加完成，请求重定向到/list
        }


    }

    @RequestMapping("/toEditDish")
    public String toEdit(Model model,Integer id){
        Dish Dish = dishService.findDishById(id);
        model.addAttribute("Dish",Dish);
        return "Dish/DishEdit"; //跳转到DishEdit.html页面
    }
    @RequestMapping("/editDish")
    public String edit(Dish dish, @RequestParam("DishName") String Dishname
            , @RequestParam("DishPrice") String DishPrice
            , @RequestParam("DishDescrib") String DishDescrib
            , @RequestParam("DeliveryTime") String DeliveryTime
            , Map<String,Object> map, HttpSession sessio){
        if(Dishname.isEmpty())
        {
            map.put("msg", "输入姓名为空");

            return "Dish/DishEdit";
        }else {
            dish.setDishName(Dishname);
            dish.setDishDeliverTime(DeliveryTime);
            dish.setDishDescrip(DishDescrib);
            dish.setDishPrice(DishPrice);
            dishService.edit(dish);
            return "redirect:/Dishlist";//获取列表数据并显示
        }
    }


    @RequestMapping("/deleteDish")
    public String edit(Integer id){
        dishService.delete(id);
        return "redirect:/Dishlist";
    }
}
