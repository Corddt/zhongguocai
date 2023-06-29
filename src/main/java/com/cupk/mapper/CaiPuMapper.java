package com.cupk.mapper;

import com.cupk.pojo.CaiPu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CaiPuMapper {
    List<CaiPu> findCaiPuById(int id);
    List<CaiPu> findAll(int page,int size);

    @Select("SELECT COUNT(*) FROM caipu")
    int count();

}
