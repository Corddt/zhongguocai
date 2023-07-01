package com.cupk.service.impl;

import com.cupk.mapper.BookMapper;
import com.cupk.pojo.Book;
import com.cupk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:BookServiceImpl
 * 描述:bookservice实现类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-07-01 12:19
 */
@Service
@Primary
public class BookServiceImpl implements BookService {
    @Autowired(required = false)
    private BookMapper bookMapper;
    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBookByID(Integer id) {
        return bookMapper.findBookByID(id);
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public int deleteBookByID(Integer id) {
        return bookMapper.deleteBookByID(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }
}
