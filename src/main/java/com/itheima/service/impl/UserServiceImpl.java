package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Value("54")
    private String str;

    @Override
    public void sava() {
        System.out.println("UserServiceImpl中的sava方法被调用了");
        userDao.sava();
        System.out.println(str);
    }
}
