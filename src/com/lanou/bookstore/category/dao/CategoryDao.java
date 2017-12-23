package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.book.domin.BookBean;
import com.lanou.bookstore.category.domin.CategoryBean;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
public class CategoryDao {
    GxQueryRunner runner=new GxQueryRunner();
/*    public List<BookBean> queryAllCategory(){
        List<BookBean> BookBeans=new ArrayList<>();
        String sql="select * from category,book where category.cid=book.cid";
        try {
            BookBeans=runner.query(sql,new BeanListHandler<BookBean>(BookBean.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BookBeans;
    }*/
public List<BookBean> queryAllCategory(){
    List<BookBean> BookBeans=new ArrayList<>();
    String sql="select bid,bname,price,author,image,book.cid from category,book where category.cid=book.cid";
    try {
        BookBeans=runner.query(sql,new BeanListHandler<BookBean>(BookBean.class));
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return BookBeans;
}
}
