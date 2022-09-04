package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author malin
 * @create 2021-11-01-19:25
 */
public interface BookDao {


    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByprice(int begin, int pageSize, int min, int max);
}
