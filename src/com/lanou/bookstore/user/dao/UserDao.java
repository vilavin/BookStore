package com.lanou.bookstore.user.dao;

import com.lanou.bookstore.user.domin.UserBean;
import com.lanou.commons.CommonUtils;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * Created by dllo on 17/12/22.
 */
public class UserDao {
    GxQueryRunner runner=new GxQueryRunner();

    long flag;


    public long insertUser(UserBean userBean){

        String sql="insert into USER(uid,username,PASSWORD,email) values(?,?,?,?)";
        try {
            flag=runner.update(sql,userBean.getUid(),userBean.getUsername(),userBean.getPASSWORD(),userBean.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }
    public long countExistUsername(String username){
        String sql="select count(*) from USER where username=?";
        try {
            flag=runner.query(sql,new ScalarHandler<>(),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }
    public long countExistEmail(String email){
        String sql="select count(*) from USER where email=?";
        try {
            flag=runner.query(sql,new ScalarHandler<>(),email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public UserBean querySpecificUserPwd(String username,String password){
        UserBean userBean=new UserBean();
        String sql="select * from USER where username=? and PASSWORD=?";
        try {
            userBean=runner.query(sql,new BeanHandler<UserBean>(UserBean.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;

    }



}
