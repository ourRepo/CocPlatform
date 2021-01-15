package com.platform.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.platform.dao.AdminDao;
import com.platform.dao.impl.AdminDaoImpl;

import com.platform.entity.Users;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding("utf-8");
			System.out.println("再次发送请求");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			
			Users users = new Users();
			users.setAccount(account);
			users.setPassword(password);
			
			AdminDao adminDao = new AdminDaoImpl();
			List<Users> userInfo = adminDao.login(users);
			
			if(userInfo.size()!=0){
				HttpSession session = request.getSession();
				Users user = userInfo.get(0);
				session.setAttribute("user", user);
				System.out.println("登录成功");
				response.sendRedirect("MainPageController");
			}else{
				System.out.println("登录失败");
				response.sendRedirect("login.jsp?st=1");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
