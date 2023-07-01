package com.cupk.service;

import com.cupk.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();//查找全部图书
    Book findBookByID(Integer id);//根据图书编号查询图书
}
