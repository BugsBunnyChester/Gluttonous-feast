package com.bugsbunnywyunj.demo.service;

import com.bugsbunnywyunj.demo.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public User findUserById(Integer id);

    public User findUserByPhone(String phone);

    /**
     * 新增
     *
     * @param user
     */
    public void save(User user);

    /**
     * 修改
     *
     * @param user
     */
    public void edit(User user);

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Integer id);


}
