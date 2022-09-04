package com.atguigu.test;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author malin
 * @create 2021-09-28-15:14
 */
public class UserDaoTest {

    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin123") == null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败");
        }else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "admin123", "123456", "wzg168@qq.com")));
    }
}