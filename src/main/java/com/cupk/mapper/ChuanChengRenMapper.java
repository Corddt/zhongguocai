package com.cupk.mapper;

import com.cupk.pojo.CaiPu;
import com.cupk.pojo.ChuanChengRen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChuanChengRenMapper {
    List<ChuanChengRen> findAll(@Param("page") int page, @Param("size") int size);
    int countPages(int size);

    @Select("SELECT COUNT(*) FROM chuanchengren")
    int count();
}
