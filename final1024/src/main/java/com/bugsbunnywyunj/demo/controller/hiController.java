package com.bugsbunnywyunj.demo.controller;


import com.bugsbunnywyunj.demo.entity.ProductInfo;
import com.bugsbunnywyunj.demo.entity.Shop;
import com.bugsbunnywyunj.demo.entity.User;
import com.bugsbunnywyunj.demo.exception.SellException;
import com.bugsbunnywyunj.demo.service.ProductService;
import com.bugsbunnywyunj.demo.service.ShopService;
import com.bugsbunnywyunj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class hiController {
    @RequestMapping("/bugsbunny.com")

    public String sayHello(Map<String,Object> map) {

        map.put("customer_service_phone", "17301231231");

        map.put("help_texts", Arrays.asList("帮助手册1","帮助手册2","帮助手册3","帮助手册4","帮助手册5"));
        map.put("help_href", Arrays.asList("help1.html","help2.html","help3.html","help4.html","help5.html"));

        return "login";//在没有配置的情况下，return "hello”; 或者return "hello"都可以，它们都会到templates/index.html去。

    }
    @RequestMapping("/register")

    public String jumpRegister(Map<String,Object> map) {
        map.put("customer_service_phone", "17301231231");

        return "register";//在没有配置的情况下，return "hello”; 或者return "hello"都可以，它们都会到templates/index.html去。

    }
    @RequestMapping("/index")

    public String jumpIndex(Map<String,Object> map) {
        map.put("customer_service_phone", "17301231231");

        return "index";//在没有配置的情况下，return "hello”; 或者return "hello"都可以，它们都会到templates/index.html去。

    }

    @RequestMapping("/in_shop")
    public String jumpenterShop1(@RequestParam("hotshopId0") String shopID,
                                 @RequestParam("hotshopName0") String password,
                                 HttpSession session, Map<String,Object> map) {
        map.put("customer_service_phone", "17301231231");

        return "shops/enterShop";//在没有配置的情况下，return "hello”; 或者return "hello"都可以，它们都会到templates/index.html去。

    }

    @Resource
    private ShopService shopService;
    @Autowired
    private UserService userService;
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session,
                        Model model)
    {
        String pawd="";
        User user;
        try {
            user=userService.findUserByPhone(username);
        }catch (Exception e)
        {
            session.setAttribute("login_msg", "用户不存在");
            return "redirect:/bugsbunny.com";
        }
        try {
            pawd=user.getPassWord();
        }catch (SellException e)
        {
            session.setAttribute("login_msg", "数据库信息异常，用户信息可能已冻结");
            map.put("msg",e.getMessage());
            return "redirect:/bugsbunny.com";
        }

        if(!StringUtils.isEmpty(username)&&pawd.equals(password))
        {

            session.setAttribute("img_src0", "images/3_j.png");
            session.setAttribute("shop_name0", "米奇妙妙屋");
            session.setAttribute("shop_price0", "10");
            session.setAttribute("login_username", user.getLastname());
            session.setAttribute("shop_url", "detailsp.html?shop_id=1");


            List<Shop> shops = shopService.getShopList();
            Shop shop=new Shop();
            shop=shopService.findShopById(1);
            session.setAttribute("hotShop", shop);
            session.setAttribute("shopos", shops);


            //return "redirect:/main.html";
            return "redirect:/index";
//            return new ModelAndView("redirect:/index", map);
        }
        else{
            session.setAttribute("login_msg", "用户密码错误");
            return "redirect:/bugsbunny.com";
//            return new ModelAndView("redirect:/bugsbunny.com", map);
        }
    }


    @Autowired
    private ProductService productService;
    @RequestMapping("/test/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       Map<String, Object> map) {
//        PageRequest request =PageRequest.of(page - 1, size);
//        Page<ProductInfo> productInfoPage = productService.findAll(request);
//        map.put("productInfoPage", productInfoPage);
//        map.put("currentPage", page);
//        map.put("size", size);
        return "product/list";
    }

}
