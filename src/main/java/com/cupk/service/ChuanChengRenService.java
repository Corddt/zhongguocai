package com.cupk.service;

import com.cupk.pojo.CaiPu;
import com.cupk.pojo.ChuanChengRen;

import java.util.List;

public interface ChuanChengRenService {
    List<ChuanChengRen> findAll(int page, int size);
    int countPages(int size);
    int calculateTotalPages(int size);
}
