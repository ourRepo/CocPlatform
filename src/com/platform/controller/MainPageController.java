package com.platform.controller;

import com.platform.dao.TopicDao;
import com.platform.dao.impl.TopicDaoImpl;
import com.platform.entity.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainPageController")
public class MainPageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        TopicDao topicDao = new TopicDaoImpl();
        HttpSession session = request.getSession();
        try {
            //1.查询置顶的话题
            List<Topic> specialTopicList = topicDao.findSpecialTopic();
            //2.查询普通的话题
            List<Topic> normalTopicList = topicDao.findNormalTopic();

            session.setAttribute("specialTopicList",specialTopicList);
            session.setAttribute("normalTopicList",normalTopicList);

            response.sendRedirect("mainPage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
