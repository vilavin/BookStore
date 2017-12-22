package com.lanou.bookstore.user.service;

import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.domin.UserBean;
import com.lanou.commons.CommonUtils;

/**
 * Created by dllo on 17/12/22.
 */
public class UserService {
    UserDao userDao=new UserDao();
    public boolean insertUser(UserBean userBean){
        userBean.setUid(CommonUtils.uuid());
        if(userDao.insertUser(userBean)>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isNameExist(String username){
        if (userDao.countExistUsername(username)>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isEmailExist(String email){
        if (userDao.countExistEmail(email)>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isPassWordRight(String username,String password){
        if(userDao.querySpecificUserPwd(username,password)!=null){
            return true;
        }
        else{
            return false;
        }

    }


}
