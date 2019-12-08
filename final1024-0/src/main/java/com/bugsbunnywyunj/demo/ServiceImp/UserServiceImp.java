package com.bugsbunnywyunj.demo.ServiceImp;

import com.bugsbunnywyunj.demo.entity.User;
import com.bugsbunnywyunj.demo.repository.UserRepository;
import com.bugsbunnywyunj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById((int) id).get();
    }

    @Override
    public User findUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
