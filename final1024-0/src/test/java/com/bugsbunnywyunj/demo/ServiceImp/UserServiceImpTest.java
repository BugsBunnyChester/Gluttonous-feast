package com.bugsbunnywyunj.demo.ServiceImp;

import com.bugsbunnywyunj.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImpTest {
    @Autowired
    private UserServiceImp userServiceImp;

    @Test
    public void findByPhone() throws Exception{
        User user=new User();
//        user.setPhone("512");
//        user.setLastname("wyj");
//        user.setPassWord("980512");
//        userServiceImp.save(user);
        user=userServiceImp.findUserByPhone("512");
        String pass="980512";
        if(Objects.equals(user.getPassWord(), pass))
        {

            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        System.out.println(user.getPassWord());
        System.out.println("alldown");
    }
}