package com.bugsbunnywyunj.demo.controller;

import com.bugsbunnywyunj.demo.entity.User;
import com.bugsbunnywyunj.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class registerControlller {
    @Resource
    private UserService userService;
    @PostMapping(value = "/user/register")
    public String register(User user,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("password_again") String password_again,
                           @RequestParam("emil") String emil,
                           @RequestParam("phone") String phone,
                           Map<String,Object> map, HttpSession session)
    {

        session.setAttribute("login_username", username);
        /*
        try：
        存贮信息语句：
        catch
         */
        if(username.isEmpty()||password.isEmpty())
        {
            map.put("msg", "信息为空");
            return "redirect:/Register";

        }else if(existPhone(phone)) {
            //否则返回msg 告知失败信息，例如手机号已注册
            String failmsg = "phone已注册";
            //数据库操作所返回的错误信息
            map.put("msg", failmsg);

            //return "redirect:/main.html";
            return "redirect:/register";
        }

        //如果用户注册成功，返回session直接登录
        else  {
            user.setLastname(username);
            user.setPhone(phone);
            userService.save(user);
            map.put("login_username", username);
            return "redirect:/index";

        }

    }

    private boolean existPhone(String phone) {
        List<User> users = userService.getUserList();
//        for (User user:users
//             ) {
//            System.out.println(user.getPhone());
//        }
        boolean flag=false;
        for (User user:users
             ) {
            String p=user.getPhone();

            if(Objects.equals(p, phone))
            {

                flag=true;
                System.out.println("get true");
            }
        }


        return flag;

    }
    @GetMapping(value = "/user/toRegister")
    public ModelAndView toshopUserRegister(Map<String,Object> map, HttpSession session)
    {
        return new ModelAndView("user/shoperRegister",map);
    }
    @GetMapping(value = "/user/toLogin")
    public ModelAndView toshopUserLogin(Map<String,Object> map, HttpSession session)
    {
        return new ModelAndView("user/shoperLogin",map);
    }
    @PostMapping(value = "/user/shoRegister")
    public ModelAndView shopUserRegister(User user,
                           @RequestParam("userLastName") String username,
                           @RequestParam("password") String password,
                           @RequestParam("password_again") String password_again,
                           @RequestParam("emil") String emil,
                           @RequestParam("phoneNumber") String phone,
                           @RequestParam("IDcdNumber") String IdcdNumber,
                           @RequestParam("trueName") String trueName,
                           Map<String,Object> map, HttpSession session)
    {

        session.setAttribute("login_username", username);
        /*
        try：
        存贮信息语句：
        catch
         */
        if(username.isEmpty()||password.isEmpty())
        {
            map.put("msg", "信息为空");
//            return "redirect:/Register";
            return new ModelAndView("user/shoperRegister", map);

        }else if(existPhone(phone)) {
            //否则返回msg 告知失败信息，例如手机号已注册
            String failmsg = "phone已注册";
            //数据库操作所返回的错误信息
            map.put("msg", failmsg);

            //return "redirect:/main.html";
//            return "redirect:/register";
            return new ModelAndView("user/shoperRegister", map);
        }

        //如果用户注册成功，返回session直接登录
        else  {
            user.setLastname(username);
            user.setPhone(phone);
            userService.save(user);
            map.put("login_username", username);
//            return "user/shoperLogin";
            return new ModelAndView("product/index", map);

        }

    }


}
