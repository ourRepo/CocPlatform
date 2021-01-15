package com.platform.controller;

import com.platform.dao.TopicDao;
import com.platform.dao.impl.TopicDaoImpl;
import com.platform.entity.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet("/TopicController")
public class TopicController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        //获取userId
        String userId = request.getParameter("userId");
        //获取当前时间
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = formatter.format(currentDate);
        //获取topicId
        String topicId = UUID.randomUUID().toString().substring(0,8);
        //获取浏览量
        int viewNum = 0;
        //获取题目
        String title = request.getParameter("title");
        //获取内容
        String content = request.getParameter("content");
        //设置状态(默认是普通)
        String status = "1";
        //获取userName
        String userName = request.getParameter("userName");

        Topic topic = new Topic();
        topic.setTopicId(topicId);
        topic.setUserId(userId);
        topic.setTitle(title);
        topic.setContent(content);
        topic.setViewNum(viewNum);
        topic.setDate(date);
        topic.setStatus(status);
        topic.setUserName(userName);

        TopicDao topicDao = new TopicDaoImpl();
        try {
            topicDao.addNewTopic(topic);
            response.sendRedirect("MainPageController");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
