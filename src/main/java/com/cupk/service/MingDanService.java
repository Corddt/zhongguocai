package com.cupk.service;

import com.cupk.pojo.CaiPu;
import com.cupk.pojo.MingDan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MingDanService {
    List<MingDan> findAll(int page, int size);
    int countPages(int size);
    int calculateTotalPages(int size);
}
