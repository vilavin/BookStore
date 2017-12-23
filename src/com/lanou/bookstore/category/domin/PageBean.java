package com.lanou.bookstore.category.domin;

import com.lanou.bookstore.book.domin.BookBean;

import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
public class PageBean<T> {
    private List<T>  beans;

    public List<T> beansgetBeans() {
        return beans;
    }

    public void setBeans(List<T> beans) {
        this.beans = beans;
    }
}
