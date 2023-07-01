package com.cupk.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 名称:FoodBook
 * 描述:用户端看到的食品图书的实体类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-07-02 01:30
 */
@Data
public class FoodBook {
    private Integer id;
    private String name;
    private String ISBN;
    private Double price;
    private String author;
    private String company;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
}
