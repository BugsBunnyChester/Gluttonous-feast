package com.bugsbunnywyunj.demo.controller;

import com.bugsbunnywyunj.demo.dto.OrderDTO;
import com.bugsbunnywyunj.demo.entity.*;
import com.bugsbunnywyunj.demo.repository.UserRepository;
import com.bugsbunnywyunj.demo.service.OrderService;
import com.bugsbunnywyunj.demo.service.ProductService;
import com.bugsbunnywyunj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.*;

//@RestController
@Controller
public class UserController {
//    @Resource
//    private UserService userService;
//
    @Autowired
    private ProductService productService;

    @RequestMapping("/in_cart")
    public String jumpenterShop1(@RequestParam("dishIdInCart") String dishID,
                                 @RequestParam("Number") String count,
                                 HttpSession session, Map<String,Object> map) {
        map.put("customer_service_phone", "17301231231");
        ProductInfo productInfo=productService.findOne(dishID);
        OrderDetail orderDetail=new OrderDetail();
        List<OrderDetail> cartDishs;
        System.out.println(count);

        if(session.getAttribute("DishsIncCart")==null) {
//            List<ProductInfo> cartDishs = new ArrayList<>();
//            cartDishs.add(productService.findOne(dishID));
             cartDishs = new ArrayList<>();

        }else{
             cartDishs = (List<OrderDetail>) session.getAttribute("DishsIncCart");
        }
            orderDetail.setProductId(productInfo.getProductId());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductName(productInfo.getProductName());
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetail.setProductQuantity(Integer.parseInt(count));
            orderDetail.setShopId(productInfo.getShopId());
            cartDishs.add(orderDetail);
            session.setAttribute("DishsIncCart", cartDishs);







        return "redirect:cart.html";//在没有配置的情况下，return "hello”; 或者return "hello"都可以，它们都会到templates/index.html去。

    }
    @Autowired
    private OrderService orderService;
    @Autowired
    private  UserService userService;
    @RequestMapping("in_confirm_order")
    public String inConfirm(@RequestParam("newslist") String[] dishIds,
                            HttpSession session, Map<String,Object> map,
                            HttpServletRequest request) {
        List<OrderDetail> cartDishs = ( List<OrderDetail>) session.getAttribute("DishsIncCart");
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderDetailList(cartDishs);
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        for (OrderDetail p:cartDishs
        ) {
            ProductInfo productInfo =  productService.findOne(p.getProductId());
//            String counts=request.getParameter("count_"+p.getProductId());
//            System.out.println(p.getProductId()+"  /"+counts+Integer.parseInt(counts));
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(p.getProductQuantity()))
                    .add(orderAmount);

            System.out.println(p.getProductQuantity());

        }

        User user=userService.findUserById((Integer) session.getAttribute("login_userID"));
        Date date=new Date();
        System.out.println(date);
        int s=date.hashCode();
        orderDTO.setOrderId(""+s);
        orderDTO.setBuyerPhone(user.getPhone());
        orderDTO.setBuyerOpenid(user.getId().toString());
        orderDTO.setBuyerName(user.getTrueName());
        orderDTO.setBuyerAddress(user.getAddress());
        orderDTO.setOrderAmount(orderAmount);

        session.setAttribute("orderDto", orderDTO);
        System.out.println(orderDTO.getOrderAmount());
//        map.put("orderDto", orderDTO);

        return "confirm_order";

    }
    @RequestMapping("new_address")
    public String newAddress(@RequestParam("place") String place,
                             @RequestParam("street") String street,
                             @RequestParam("buyerName") String buyerName,
                             @RequestParam("phone") String phone,
                             HttpSession session, Map<String,Object> map)
    {
        User user=userService.findUserById((Integer) session.getAttribute("login_userID"));
        user.setAddress(place+street+"  "+buyerName+phone+",");
        OrderDTO orderDTO= (OrderDTO) session.getAttribute("orderDto");
        orderDTO.setBuyerAddress(user.getAddress());
        session.setAttribute("orderDto", orderDTO);
        return "confirm_order";

    }

    @RequestMapping("confirm_order_acton")
    public String confirmOrder(
                               HttpSession session, Map<String,Object> map,
                               HttpServletRequest request) {
        User user=userService.findUserById((Integer) session.getAttribute("login_userID"));
        System.out.println((Integer) session.getAttribute("login_userID"));
        OrderDTO orderDTO= (OrderDTO) session.getAttribute("orderDto");
        orderDTO=orderService.create(orderDTO);
        session.setAttribute("orderDto", orderDTO);

        return "cart";
    }
//    @GetMapping("/user")
//    @ResponseBody
//    public User insterUser(User user){
//        User save=userRepository.save(user);
//        return save;
//    }
//
//    @RequestMapping("/")
//    public String index(){
//        return "redirect:/list"; //重定向到 /list
//    }
//
//    @RequestMapping("/list")
//    public String lsit(Model model){
//        List<User> users = userService.getUserList();
//        model.addAttribute("users",users);
//        return "user/list";
//    }
//
//    @RequestMapping("/toAdd")
//    public String toadd(User user){
//        return "user/userAdd";//跳转到userAdd.html
//    }
//
//    @RequestMapping("/add")
//    public String add(User user, @RequestParam("userName") String username
//            , Map<String,Object> map, HttpSession sessio){
//        if(username.isEmpty())
//        {
//            map.put("msg", "输入姓名为空");
//            System.out.println("输入为空");
//            return "user/userAdd";
//        }else {
//            user.setLastname(username);
//
//            userService.save(user);
//            return "redirect:/list";//添加完成，请求重定向到/list
//        }
//
//
//    }
//
//    @RequestMapping("/toEdit")
//    public String toEdit(Model model,Integer id){
//        User user = userService.findUserById(id);
//        model.addAttribute("user",user);
//        return "user/userEdit"; //跳转到userEdit.html页面
//    }
//    @RequestMapping("/edit")
//    public String edit(User user,@RequestParam("userName") String username
//            ,@RequestParam("password") String password
//            ,@RequestParam("age") String age
//            ){
//        user.setLastname(username);
//        user.setPhone(password);
//        userService.edit(user);
//        return "redirect:/list";//获取列表数据并显示
//    }
//
//    @RequestMapping("/delete")
//    public String edit(Integer id){
//        userService.delete(id);
//        return "redirect:/list";
//    }

//    @RequestMapping("/list")
////    public String list(ModelMap model, @RequestParam(value = "page",defaultValue = "0")Integer page,
////                       @RequestParam(value="size",defaultValue = "6")Integer size){
////        Sort sort=new Sort(Sort.Direction.DESC,"id");
////        Pageable pageable=new PageRequest(page,size,sort);
////        Page<User> users=userRepository.findList(pageable);
////        model.addAttribute("users",users);
////        return "user/list";
////    }



}
