package com.lanou.bookstore.user.service;

import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.domin.UserBean;

/**
 * Created by dllo on 17/12/22.
 */
public class UserService {
    UserDao userDao=new UserDao();
    public boolean insertUser(UserBean userBean){
        return userDao.insertUser(userBean);
    }
}
