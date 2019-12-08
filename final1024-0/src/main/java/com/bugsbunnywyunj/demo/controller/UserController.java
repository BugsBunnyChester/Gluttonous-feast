package com.bugsbunnywyunj.demo.controller;

import com.bugsbunnywyunj.demo.entity.User;
import com.bugsbunnywyunj.demo.repository.UserRepository;
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
import javax.servlet.http.HttpSession;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@RestController
@Controller
public class UserController {
//    @Resource
//    private UserService userService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @GetMapping("/user/{id}")
//    @ResponseBody
//    public User getUser(@PathVariable("id")Integer id)
//    {
//        User user= userRepository.findById(id).get();
//        return user;
//    }
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
