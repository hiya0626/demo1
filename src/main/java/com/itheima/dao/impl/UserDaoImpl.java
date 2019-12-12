package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void sava() {
        System.out.println("UserDaoImpl中的sava方法被调用");
    }
}
