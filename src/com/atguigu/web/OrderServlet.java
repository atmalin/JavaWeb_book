package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author malin
 * @create 2021-11-29-15:41
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        System.out.println("orderServlet程序在[" + Thread.currentThread().getName() + "]中");

        Integer userId = loginUser.getId();
//        调用orderService.createOrder(Cart,UserId);生成订单
        String orderId = orderService.createOrder(cart, userId);

//            需要给每一个Servlet中每一个方法调用Service.xxx()都需要加上try-catch



//        req.setAttribute("orderId", orderId);
        //请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
