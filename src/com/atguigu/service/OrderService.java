package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @author malin
 * @create 2021-11-29-15:13
 */
public interface OrderService {

    public String createOrder(Cart cart,Integer userId);
}
