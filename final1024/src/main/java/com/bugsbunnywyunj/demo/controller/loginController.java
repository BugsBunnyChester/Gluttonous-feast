package com.bugsbunnywyunj.demo.controller;

import com.bugsbunnywyunj.demo.entity.ProductInfo;
import com.bugsbunnywyunj.demo.entity.Shop;
import com.bugsbunnywyunj.demo.entity.User;
import com.bugsbunnywyunj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;
import com.bugsbunnywyunj.demo.service.ShopService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class loginController {
    @Resource
    private ShopService shopService;
    @Autowired
    private UserService userService;
    @PostMapping(value = "/user/login1")
    public String login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Map<String,Object> map, HttpSession session,
                              Model model)
    {
        String pawd="";
        User user;
        user=userService.findUserByPhone(username);
        pawd=user.getPassWord();
        if(!StringUtils.isEmpty(username)&&pawd.equals(password))
        {

            session.setAttribute("img_src0", "images/3_j.png");
            session.setAttribute("shop_name0", "米奇妙妙屋");
            session.setAttribute("shop_price0", "10");
            session.setAttribute("login_username", user.getLastname());
            session.setAttribute("shop_url", "detailsp.html?shop_id=1");

//            for(int i=0;i<10;i++) {
//                Shop shop = new Shop();
//                Random random = new Random();
//                int a = random.hashCode();
//                String descrip = "" + a;
//
//                shop.setShopDexcrip(descrip);
//                StringBuilder desc = new StringBuilder(descrip);
//                desc.reverse();
//                descrip = desc.toString();
//
//                shop.setShopName(descrip);
//                shopService.save(shop);
//            }

            List<Shop> shops = shopService.getShopList();
            Shop shop=new Shop();
            shop=shopService.findShopById(1);
//            Sort sort=new Sort(Sort.Direction.ASC,);
//            PageRequest request = new PageRequest(1,2, Sort.Direction.ASC,"");
//            Page<Shop> shopInfoPage = shopService.getShopList(request);


            session.setAttribute("hotShop", shop);
            session.setAttribute("shopos", shops);


            //return "redirect:/main.html";
            return "redirect:/index";
//            return new ModelAndView("redirect:/index", map);
        }
        else{
            session.setAttribute("login_msg", "用户密码错误");
            return "/bugsbunny.com";
//            return new ModelAndView("redirect:/bugsbunny.com", map);
        }
    }
    @PostMapping(value = "/user/shopLogin")
    public ModelAndView shoperLogin(@RequestParam("phoneNumber") String phoneNumber,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session,
                        Model model)
    {
        User user=userService.findUserByPhone(phoneNumber);
        if(user.getLastname().isEmpty()){
            map.put("msg", "用户不存在");
            return new ModelAndView("user/shoperRegister", map);
        }
        if(user.getPassWord().isEmpty())
        {
            map.put("msg", "用户已冻结，请申请恢复");
            return new ModelAndView("user/shopLogin", map);
        }

        if(!StringUtils.isEmpty(password)&&user.getPassWord().equals(password))
        {
            session.setAttribute("login_username", user.getLastname());
            return new ModelAndView("product/index", map);
        }else{
            return new ModelAndView("user/shoperRegister", map);
        }

    }
}
