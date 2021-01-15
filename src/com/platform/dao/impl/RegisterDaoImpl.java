package com.platform.dao.impl;

import com.platform.dao.RegisterDao;
import com.platform.entity.Users;
import com.platform.util.JDBCUtil;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    public void registerNewMember(Users user) throws Exception {
        String account = user.getAccount();
        String password = user.getPassword();
        String gender = user.getGender();
        String userId = user.getUserId();
        String userName = user.getUserName();
        String phoneNumber = user.getPhoneNumber();
        String birthDay = user.getBirthDay();
        String userStatic = user.getUserStatus();
        String str = "insert into user(userId,userName,birthDay,gender,phoneNumber,account,password,userstatic) values(?,?,?,?,?,?,?,?)";
        JDBCUtil.executeUpdate(str,new Object[]{userId,userName,birthDay,gender,phoneNumber,account,password,userStatic});
    }
}
