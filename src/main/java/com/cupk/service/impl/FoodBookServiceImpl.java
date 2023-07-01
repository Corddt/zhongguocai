package com.cupk.service.impl;

import com.cupk.mapper.ChuanChengRenMapper;
import com.cupk.mapper.FoodBookMapper;
import com.cupk.pojo.ChuanChengRen;
import com.cupk.pojo.FoodBook;
import com.cupk.service.FoodBookService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:FoodBookServiceImpl
 * 描述:foodbookservice的实现类（用户端的图书）
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-07-02 01:33
 */
@Service
@Primary
public class FoodBookServiceImpl implements FoodBookService {
    @Autowired(required = false)
    private FoodBookMapper foodBookMapper;
    @Override
    public List<FoodBook> findAll(int page, int size) {
        page = Math.max(1, page);
        size = Math.max(1, size);
        PageHelper.startPage(page, size);
        return foodBookMapper.findAll((page - 1) * size, size);
    }

    @Override
    public int countPages(int size) {
        long count = foodBookMapper.count();
        return (int) Math.ceil((double) count / size);
    }

    @Override
    public int calculateTotalPages(int size) {
        long count = foodBookMapper.count();
        return (int) Math.ceil((double) count / size);
    }
}
