package com.atguigu.dao;

import com.atguigu.pojo.Order;

/**
 * @author malin
 * @create 2021-11-29-14:47
 */
public interface OrderDao {

    public int saveOrder(Order order);
}
