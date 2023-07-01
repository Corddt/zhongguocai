package com.cupk.mapper;

import com.cupk.pojo.Book;

import java.util.List;

public interface BookMapper {
    List<Book> findAllBooks();//查询全部图书
    Book findBookByID(Integer id);//根据图书编号查询图书
}
