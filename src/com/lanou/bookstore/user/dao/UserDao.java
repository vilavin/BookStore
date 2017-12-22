package com.lanou.bookstore.user.dao;

import com.lanou.bookstore.user.domin.UserBean;
import com.lanou.commons.CommonUtils;
import com.lanou.jdbc.GxQueryRunner;

import java.sql.SQLException;

/**
 * Created by dllo on 17/12/22.
 */
public class UserDao {
    GxQueryRunner runner=new GxQueryRunner();

    int flag;
    public boolean insertUser(UserBean userBean){

        String sql="insert into USER(uid,username,PASSWORD,email) values(?,?,?,?)";
        try {
            flag=runner.update(sql,userBean.getUid(),userBean.getUsername(),userBean.getPASSWORD(),userBean.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (flag>0){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
