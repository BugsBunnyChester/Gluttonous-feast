package com.bugsbunnywyunj.demo.controller;
import com.bugsbunnywyunj.demo.repository.ShopRepository;
import com.bugsbunnywyunj.demo.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Resource
    private ShopService shopService;

    private ShopRepository shopREpository;
    @RequestMapping("/in_shop")
    public String jumpenterShop1(Map<String,Object> map,
                                 @RequestParam("hotshopId0") String shopID,
                                 @RequestParam("hotshopName0") String password,
                                  HttpSession session,
                                 Model model) {
        map.put("customer_service_phone", "17301231231");

        return "shops/enterShop";//在没有配置的情况下，return "hello”; 或者return "hello"都可以，它们都会到templates/index.html去。

    }

}
