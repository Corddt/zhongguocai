package com.cupk.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 名称:Book
 * 描述:美食书籍实体类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-07-01 12:05
 */
@Data
public class Book {
    private Integer id;
    private String name;
    private String ISBN;
    private Double price;
    private String author;
    private String company;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
}
