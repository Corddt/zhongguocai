package com.cupk.service.impl;

import com.cupk.mapper.ChuanChengRenMapper;
import com.cupk.pojo.ChuanChengRen;
import com.cupk.service.ChuanChengRenService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:ChuanChengRenImpl
 * 描述:ChuanChengRenService的实现类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-30 11:33
 */
@Service
@Primary
public class ChuanChengRenImpl implements ChuanChengRenService {
    @Autowired(required = false)
    private ChuanChengRenMapper chuanChengRenMapper;
    @Override
    public List<ChuanChengRen> findAll(int page, int size) {
        page = Math.max(1, page);
        size = Math.max(1, size);
        PageHelper.startPage(page, size);
        return chuanChengRenMapper.findAll((page - 1) * size, size);
    }

    @Override
    public int countPages(int size) {
        long count = chuanChengRenMapper.count();
        return (int) Math.ceil((double) count / size);
    }

    @Override
    public int calculateTotalPages(int size) {
        long count = chuanChengRenMapper.count();
        return (int) Math.ceil((double) count / size);
    }
}
