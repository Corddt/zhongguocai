package com.cupk.mapper;

import com.cupk.pojo.ChuanChengRen;
import com.cupk.pojo.FoodBook;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FoodBookMapper {
    List<FoodBook> findAll(@Param("page") int page, @Param("size") int size);
    int countPages(int size);

    @Select("SELECT COUNT(*) FROM food_book")
    int count();
}
