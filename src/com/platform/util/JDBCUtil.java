package com.platform.util;

import java.sql.*;

public class JDBCUtil {

	public static PreparedStatement prestatement;
	public static Connection conn;
	public static ResultSet rst;

	//数据库地址
	private static String URL = "jdbc:mysql://localhost:3306/cocplatform?serverTimezone=Asia/Shanghai";
	//取得驱动程序
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";//新mysql写法，注意不是com.mysql.jdbc.Driver了
	//private static String DRIVER = "com.mysql.jdbc.Driver";
	//取得用户
	private static String USER = "root";
	//登录密码
	private static String PASSWORD = "123456";

	static{
		try {
			Class.forName(DRIVER);//将"com.mysql.jdbc.Driver"类的Class类对象加载到运行时内存中
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//获取连接的方法
	public static Connection getConnection() throws Exception{
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("连接服务器数据库成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	//关闭的方法
	public static void closeConnection() throws Exception{
		if(rst!=null){
			rst.close();
		}
		if(conn!=null){
			conn.close();
		}
		if(prestatement!=null){
			prestatement.close();
		}
	}
	//通用的执行增加,删除,修改方法
	public static int executeUpdate(String sqlstr,Object[] objs) throws Exception{
		int nums=0;
		try {
			//获取连接
			getConnection();
			//获取执行对象
			prestatement=conn.prepareStatement(sqlstr);
			//设置动态参数
			if(objs!=null){
				for (int i = 0; i < objs.length; i++) {
					prestatement.setObject(i+1, objs[i]);

				}
			}
			//执行方法获取结果
			nums=prestatement.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		}finally {
			closeConnection();
		}
		return nums;
	}

	public static void main(String[] args) throws Exception {

		JDBCUtil.getConnection();
	}
}
