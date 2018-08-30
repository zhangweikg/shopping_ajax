package com.software.service;

import com.software.dao.UsersDao;
import com.software.domain.UserLogInfo;
import com.software.domain.UserRegisterInfo;

public class UsersService {
    UsersDao usersDao = new UsersDao();
    public boolean login(UserLogInfo user){
        return usersDao.findByNameAndPwd(user);
    }

    public boolean register(UserRegisterInfo userRegisterInfo) {
        return usersDao.add(userRegisterInfo);
    }

    public boolean isExistName(String txt_name) {
        return usersDao.findByName(txt_name);
    }

    public UserRegisterInfo getUserInfo(String txt_name) {
        return usersDao.returnUserInfo(txt_name);
    }

    public boolean validate(String txt_name) {
        return usersDao.findByName(txt_name);
    }
}
