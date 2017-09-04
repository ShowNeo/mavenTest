package com.blog.dao;

import com.blog.bean.User;
import com.blog.dao.anno.DBField;
import com.blog.dao.anno.DBSQL;
import com.blog.dao.anno.SELECT;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshaonan on 17/8/29.
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://127.0.0.1/blog";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String pwd = "wsn";

    public static Connection conn = null;
    public static PreparedStatement pst = null;

    private static DBHelper dbHelper = null;

    static {
        try{
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, pwd);//获取连接
            //pst = conn.prepareStatement(sql);//准备执行语句
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }

    public static DBHelper getInstance(){
        if(dbHelper == null){
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public Connection getConn(){
        return conn;
    }

    public PreparedStatement getPst(String sql){
        try {
            pst = conn.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("getPst fail!");
            e.printStackTrace();
        }
        return pst;
    }

    public void close(){
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> executeSelect(Class clazz, String method, Class<?>[] paramTypes, String... params) {
        try {
            Method method1 = clazz.getDeclaredMethod(method, paramTypes);
            method1.setAccessible(true);
            SELECT dbsql = method1.getAnnotation(SELECT.class);
            Annotation[][] annotations = method1.getParameterAnnotations();
            DBField dbField = (DBField) annotations[0][0];
            if (dbsql == null) {
                throw new Exception("sql is not exist");
            }
            String sql = dbsql.value();
            String executeSql = anaSql(sql, dbField.value(), params);
            List<T> result = doSelect(executeSql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> List<T> doSelect(String sql) throws SQLException {
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<T> resultList = new ArrayList<T>();
        while(rs.next()) {
            String password = rs.getString("password");
            resultList.add((T) password);
        }
        return resultList;
    }
    private static String anaSql(String sql, String dbField, String... params) {
        String result = null;
        String symble = "#{" + dbField + "}";
        for (String temp : params) {
            result = sql.replace(symble, temp);
        }
        return result;
    }

    public static <T> T autoDo() {
        return null;
    }

    public static void main(String[]  args) throws NoSuchMethodException {
//        DBHelper.execute(UserDao.class, "selectUser", "test");
    }
}
