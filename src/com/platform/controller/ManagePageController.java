package com.platform.controller;

import com.platform.dao.AdminDao;
import com.platform.dao.TopicDao;
import com.platform.dao.impl.AdminDaoImpl;
import com.platform.dao.impl.TopicDaoImpl;
import com.platform.entity.Topic;
import com.platform.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ManagePageController")
public class ManagePageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        TopicDao topicDao = new TopicDaoImpl();
        AdminDao adminDao = new AdminDaoImpl();
        HttpSession session = request.getSession();


        try {
            //查询全部话题
            List<Topic> allTopicList = topicDao.findAllTopic();
            //查询用户（状态为2,3）
            List<Users> userList = adminDao.findSomeUser();
            session.setAttribute("allTopicList",allTopicList);
            session.setAttribute("userList",userList);

            response.sendRedirect("managePage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
