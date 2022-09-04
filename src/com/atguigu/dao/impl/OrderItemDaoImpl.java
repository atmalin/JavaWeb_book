package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

/**
 * @author malin
 * @create 2021-11-29-14:55
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{
    @Override
    public int saveOrderItem(OrderItem orderItem) {

        System.out.println("OrderItemDaoImpl[" + Thread.currentThread().getName() + "]中");

        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
