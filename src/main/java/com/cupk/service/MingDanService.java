package com.cupk.service;

import com.cupk.pojo.MingDan;

import java.util.List;

public interface MingDanService {
    List<MingDan> findAll(int page, int size);
    int countPages(int size);
    int calculateTotalPages(int size);

    List<MingDan> findMingDanByStr(String searchStr);

}
