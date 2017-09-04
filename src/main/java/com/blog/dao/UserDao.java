package com.blog.dao;

import com.blog.bean.User;
import com.blog.dao.anno.Component;
import com.blog.dao.anno.DBField;
import com.blog.dao.anno.DBSQL;
import com.blog.dao.anno.SELECT;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangshaonan on 17/8/29.
 */
@Component
public class UserDao extends DBBase {

    @SELECT("select * from user where name in (#{abc.list});")
    public static String selectIn(@DBField("userName") List<String> abc){
        return null;
    }


//    public boolean deleteUser(Integer userId);
//    public List<User> findAll() throws SQLException, IOException;
//    public User findById(Integer userId);
//    public List<User> findByName(String userName);
//    public boolean updateUser(User user);
}
