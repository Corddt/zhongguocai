package com.cupk.service;

import com.cupk.pojo.ChuanChengRen;
import com.cupk.pojo.FoodBook;

import java.util.List;

public interface FoodBookService {
    List<FoodBook> findAll(int page, int size);
    int countPages(int size);
    int calculateTotalPages(int size);
}
