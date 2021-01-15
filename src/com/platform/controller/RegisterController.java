package com.platform.controller;

import com.platform.dao.AdminDao;
import com.platform.dao.RegisterDao;
import com.platform.dao.impl.AdminDaoImpl;
import com.platform.dao.impl.RegisterDaoImpl;
import com.platform.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            request.setCharacterEncoding("utf-8");
            String account = request.getParameter("account");
            String password = request.getParameter("password");
            String userName = request.getParameter("userName");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            String birthDay = request.getParameter("birthDay");

            //判断账号是否存在
            AdminDao adminDao = new AdminDaoImpl();
            List<Users> userList = adminDao.checkAccount(account);
            if(userList.size()!=0){
                response.sendRedirect("register.jsp?st=1");
            }else{
                //添加新账号
                Users user = new Users();
                user.setAccount(account);
                user.setPassword(password);
                user.setBirthDay(birthDay);
                if("1".equals(gender)){
                    gender = "男";
                }else{
                    gender = "女";
                }
                user.setGender(gender);
                user.setPhoneNumber(phoneNumber);
                user.setUserName(userName);
                user.setUserStatus("3");
                String userId = UUID.randomUUID().toString().substring(0,8);
                user.setUserId(userId);

                RegisterDao register = new RegisterDaoImpl();
                register.registerNewMember(user);

                response.sendRedirect("login.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
