package com.blog.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangshaonan on 17/8/29.
 */
public class UserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");

        String userName=request.getParameter("username");
        String userPassword=request.getParameter("userpassword");
        String info="";
        if(("wcz".equals(userName))&& "1234".equals(userPassword))
        {
            info="欢迎你"+userName+"!";
            request.setAttribute("info1", info);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }
    }

}
