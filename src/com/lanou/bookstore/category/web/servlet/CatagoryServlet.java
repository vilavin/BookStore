package com.lanou.bookstore.category.web.servlet;

import com.lanou.bookstore.book.domin.BookBean;
import com.lanou.bookstore.category.service.CatagoryService;
import sun.jvm.hotspot.debugger.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
@WebServlet(name = "CatagoryServlet",urlPatterns = "/catagory")
public class CatagoryServlet extends HttpServlet {
    CatagoryService service=new CatagoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        String method=request.getParameter("method");
        switch (method){
            case "all":
                queryAllCategory(request,response);
                break;
        }
    }

    private void queryAllCategory(HttpServletRequest request, HttpServletResponse response) {
        List<BookBean> bookBeans=service.queryAllCategory();
        ///哈哈哈
        request.setAttribute("bookBeans",bookBeans);
        request.getRequestDispatcher("/jsps/book/list.jsp");

    }
}
