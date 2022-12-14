package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author malin
 * @create 2021-09-30-20:36
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用userService.login()登录处理业务
        User loginUser = userService.Login(new User(null, username, password, null));
        //如果等于null，说明登录失败！
        if (loginUser == null) {
            //跳回登录页面
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username",username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            //跳到成功页面login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}
