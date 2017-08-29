package com.blog.dao;

import com.blog.bean.User;

import java.util.List;

/**
 * Created by wangshaonan on 17/8/29.
 */
public interface UserDao {
    public boolean saveUser(User user);
    public boolean deleteUser(Integer userId);
    public List<User> findAll();
    public User findById(Integer userId);
    public List<User> findByName(String userName);
    public boolean updateUser(User user);
}