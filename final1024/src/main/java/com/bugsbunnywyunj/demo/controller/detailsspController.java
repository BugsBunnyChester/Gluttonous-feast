package com.bugsbunnywyunj.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class detailsspController {

    @PostMapping(value = "/user/buy")
    public String register(@RequestParam("username") String username,
                           @RequestParam("spid") String password,
                           @RequestParam("count") String count,
                           Map<String,Object> map, HttpSession session) {
        //加入购物车或者支付时必须从数据库获取信息，否则亏大，根据商品id显示的细节页面，
        //从数据库查出菜品信息，
        /*
        数据库查询商品信息的代码：
         */
        String sp_name="";//从数据库查出的商品名称
        String sp_price="";//
        String sp_shopname="";//
        int total_price=(Integer.valueOf(count)*(Integer.valueOf(sp_price)));
        session.setAttribute("sp_name", sp_name);
        session.setAttribute("sp_price",sp_price);
        session.setAttribute("total_price",total_price );//仅仅供顾客当前看，支付时再次进行
        session.setAttribute("sp_shopname",sp_shopname);

        session.setAttribute("login_username", username);
        return "cart";//购物车

    }
}
