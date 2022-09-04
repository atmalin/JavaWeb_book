package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * @author malin
 * @create 2021-11-29-14:49
 */
public class OrderDaoImpl extends BaseDao implements OrderDao{
    @Override
    public int saveOrder(Order order) {

        System.out.println("OrderDaoImpl[" + Thread.currentThread().getName() + "]中");

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
