package com.cupk.mapper;

import com.cupk.pojo.ChuanChengRen;
import com.cupk.pojo.ShiCai;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShiCaiMapper {
    List<ShiCai> findAll(@Param("page") int page, @Param("size") int size);
    int countPages(int size);

    @Select("SELECT COUNT(*) FROM shicai")
    int count();
}
