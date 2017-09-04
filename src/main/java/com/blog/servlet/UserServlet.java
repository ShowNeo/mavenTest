package com.blog.servlet;

import com.blog.bean.User;
import com.blog.dao.DBBase;
import com.blog.dao.DBHelper;
import com.blog.dao.UserDao;
import com.blog.dao.anno.Autowire;
import com.blog.dao.anno.Component;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangshaonan on 17/8/29.
 */
@Component
public class UserServlet extends HttpServlet {

    @Autowire
    UserDao userDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");

        String userName=request.getParameter("name");
        String userPassword=request.getParameter("password");

//        UserDaoImpl dao = new UserDaoImpl();
//        List<User> users = dao.findByName(userName);
//        List<String> password = DBHelper.executeSelect(UserDao.class, "selectUser", userName);
        Map<String, String> map = new HashMap<>();
        map.put("name", userName);
        List<User> users = null;
        try {
            users = userDao.select(User.class, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(userPassword.equals(users.get(0).getPassword())){
            request.getRequestDispatcher("/success.jsp?username=" + userName).forward(request,response);
            return;
        }

    }

}
