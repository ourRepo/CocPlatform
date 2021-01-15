package com.platform.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.platform.dao.AdminDao;
import com.platform.entity.Users;
import com.platform.util.JDBCUtil;

public class AdminDaoImpl implements AdminDao{

	//登录
	public List<Users> login(Users users) throws Exception {
		String account = users.getAccount();
		String password = users.getPassword();

		String sqlStr = "select * from user where account = ? and password = ?";
		List<Users> usersInfo = selectUserBySql(sqlStr,new Object[]{account,password});
		return usersInfo;
	}

	//查询账号是否存在
	public List<Users> checkAccount(String account) throws Exception {
		String sqlStr = "select * from user where account = ?";
		List<Users> usersInfo = selectUserBySql(sqlStr,new Object[]{account});
		return usersInfo;
	}

	//查询部分用户
	public List<Users> findSomeUser() throws Exception {
		String sqlStr = "select * from user where userstatus = '2' or userstatus = '3'";
		List<Users> userList = selectUserBySql(sqlStr,new Object[]{});
		return userList;
	}

	private List<Users> selectUserBySql(String sqlStr, Object[] objs) throws Exception{
		JDBCUtil.getConnection();
		JDBCUtil.prestatement = JDBCUtil.conn.prepareStatement(sqlStr);
		if(objs != null && objs.length != 0){
			for(int i=0;i<objs.length;i++){
				JDBCUtil.prestatement.setObject(i+1, objs[i]);
			}
		}
		JDBCUtil.rst = JDBCUtil.prestatement.executeQuery();
		List<Users> usersList = new ArrayList<Users>();
		while(JDBCUtil.rst.next()){	
			Users users = new Users();
			users.setUserId(JDBCUtil.rst.getString("userid"));
			users.setAccount(JDBCUtil.rst.getString("account"));
			users.setPassword(JDBCUtil.rst.getString("password"));
			users.setUserName(JDBCUtil.rst.getString("username"));
			users.setBirthDay(JDBCUtil.rst.getString("birthday"));
			users.setGender(JDBCUtil.rst.getString("gender"));
			users.setPhoneNumber(JDBCUtil.rst.getString("phoneNumber"));
			users.setUserStatus(JDBCUtil.rst.getString("userStatus"));
			usersList.add(users);
		}
		return usersList;
		
	}
	

}
