package com.cupk.service;

import com.cupk.pojo.ChuanChengRen;
import com.cupk.pojo.ShiCai;

import java.util.List;

public interface ShiCaiService {
    List<ShiCai> findAll(int page, int size);
    int countPages(int size);
    int calculateTotalPages(int size);
}
