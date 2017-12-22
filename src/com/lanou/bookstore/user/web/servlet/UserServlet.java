package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.user.domin.UserBean;
import com.lanou.bookstore.user.service.UserService;
import com.lanou.commons.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
/**
 * Created by dllo on 17/12/22.
 */
@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        String method=request.getParameter("method");
        switch (method){
            case "register":
                insertUser(request,response);
                break;
            case "login":
                loginUser(request,response);
                break;
        }

    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        UserBean userBean=CommonUtils.toBean(request.getParameterMap(),UserBean.class);
        try {
        if (userService.isNameExist(userBean.getUsername())){
            if (userService.isPassWordRight(userBean.getUsername(),userBean.getPASSWORD())){
                request.getRequestDispatcher("/index.jsp").forward(request,response);

            }
            else {
                request.setAttribute("msg","密码错误!");
                request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
            }

        }
        else {
            request.setAttribute("msg","用户名不存在!");
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);

        }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        UserBean userBean=CommonUtils.toBean(request.getParameterMap(),UserBean.class);

        try {
        if (userService.isNameExist(userBean.getUsername())){

                request.setAttribute("msg","用户名已存在!");
                request.getRequestDispatcher("/jsps/user/regist.jsp").forward(request,response);

        }
        if (userService.isEmailExist(userBean.getEmail())){

                request.setAttribute("msg","邮箱已存在!");
                request.getRequestDispatcher("/jsps/user/regist.jsp").forward(request,response);
            }

         else{

            boolean flag=userService.insertUser(userBean);
            if (flag){
                request.setAttribute("msg","注册成功");
            }
            else{
                request.setAttribute("msg","注册失败");
            }
            request.getRequestDispatcher("/jsps/msg.jsp").forward(request,response);
        }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
