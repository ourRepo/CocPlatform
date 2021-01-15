package com.platform.dao;

import com.platform.entity.Users;

import java.util.List;

public interface AdminDao {
	
	List<Users> login(Users users) throws Exception;
	List<Users> checkAccount(String account) throws Exception;
	List<Users> findSomeUser()throws Exception;
}
