package com.cupk.service.impl;

import com.cupk.mapper.ShiCaiMapper;
import com.cupk.pojo.ShiCai;
import com.cupk.service.ShiCaiService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 名称:ShiCaiServiceImpl
 * 描述:ShiCaiService的实现类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-30 16:56
 */
public class ShiCaiServiceImpl implements ShiCaiService {
    @Autowired(required = false)
    private ShiCaiMapper shiCaiMapper;
    @Override
    public List<ShiCai> findAll(int page, int size) {
        page = Math.max(1, page);
        size = Math.max(1, size);
        PageHelper.startPage(page, size);
        return shiCaiMapper.findAll((page - 1) * size, size);
    }

    @Override
    public int countPages(int size) {
        long count = shiCaiMapper.count();
        return (int) Math.ceil((double) count / size);
    }

    @Override
    public int calculateTotalPages(int size) {
        long count = shiCaiMapper.count();
        return (int) Math.ceil((double) count / size);
    }
}
