package com.cupk.mapper;

import com.cupk.pojo.CaiPu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CaiPuMapper {
    CaiPu findCaiPuById(int id);
    List<CaiPu> findAll(@Param("page") int page, @Param("size") int size);
    int countPages(int size);

    @Select("SELECT COUNT(*) FROM caipu")
    int count();
}

