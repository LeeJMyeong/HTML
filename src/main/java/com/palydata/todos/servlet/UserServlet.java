package com.palydata.todos.servlet;

import com.palydata.todos.dao.UserDao;
import com.palydata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/user.html").forward(req,resp);
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        User user = new User(null, username,password,name,null);
        UserDao userDao = new UserDao();
        userDao.insert(user);
        resp.sendRedirect("/login");;
        resp.setStatus(201);
    }
}
