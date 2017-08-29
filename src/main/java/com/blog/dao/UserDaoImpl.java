package com.blog.dao;

import com.blog.bean.User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshaonan on 17/8/29.
 */
public class UserDaoImpl implements UserDao{
    private DBHelper db = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public UserDaoImpl(){
        db = DBHelper.getInstance();
    }

    public boolean saveUser(User user) {
        if(user == null)
            return false;
        Integer id = user.getId();
        String name = user.getName();
        String pwd = user.getPassword();
        String phone = user.getPhone();
        String email = user.getEmail();
        String sql = "insert into user(id,name,password,phone,email) values(?,?,?,?,?)";
        try{
            st=db.getConn().prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,pwd);
            st.setString(4,phone);
            st.setString(5,email);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteUser(Integer userId) {
        String sql = "delete from user where id=?";
        try {
            st=db.getConn().prepareStatement(sql);
            st.setInt(1,userId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return true;
    }

    public List<User> findAll() throws SQLException,IOException {
        String sql = "select * from user";
        List<User> users = new ArrayList<User>();
        try{
            st=db.getConn().prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setEmail(rs.getString(5));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(rs != null)
                rs.close();
            if(st !=null)
                st.close();
        }
        return users;
    }

    public User findById(Integer userId) {
        String sql = "SELECT * FROM user WHERE id=?";
        User user = new User();
        try {
            st=db.getConn().prepareStatement(sql);
            st.setInt(1,userId);
            rs = st.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setEmail(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findByName(String userName) {
        String sql = "SELECT * FROM user WHERE name=?";
        List<User> users = new ArrayList<User>();
        try {
            st=db.getConn().prepareStatement(sql);
            st.setString(1,userName);
            rs = st.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setEmail(rs.getString(5));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE USER SET name= ?,passowrd=?, phone=?, email=? WHERE id=?";
        try {
            st=db.getConn().prepareStatement(sql);
            st.setString(1,user.getName());
            st.setString(2,user.getPassword());
            st.setString(3,user.getPhone());
            st.setString(4,user.getEmail());
            st.setInt(5,user.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
