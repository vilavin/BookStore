package com.lanou.bookstore.category.service;

import com.lanou.bookstore.book.domin.BookBean;
import com.lanou.bookstore.category.dao.CategoryDao;

import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
public class CatagoryService {
    CategoryDao categoryDao=new CategoryDao();
    public List<BookBean> queryAllCategory(){
        return categoryDao.queryAllCategory();
    }
}
