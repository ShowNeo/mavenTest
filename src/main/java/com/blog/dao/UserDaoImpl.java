package com.blog.dao;

import com.blog.bean.User;

import java.util.List;

/**
 * Created by wangshaonan on 17/8/29.
 */
public class UserDaoImpl implements UserDao{
    public boolean saveUser(User user) {
        return false;
    }

    public boolean deleteUser(Integer userId) {
        return false;
    }

    public List<User> findAll() {
        return null;
    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByName(String userName) {
        return null;
    }

    public boolean updateUser(User user) {
        return false;
    }
}
