package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by wangshaonan on 17/8/29.
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://127.0.0.1/blog";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String pwd = "wsn";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql){
        try{
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, pwd);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }

    public void close(){
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
