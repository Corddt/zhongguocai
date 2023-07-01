package com.cupk.service.impl;

import com.cupk.mapper.ChuanChengRenMapper;
import com.cupk.mapper.MingDanMapper;
import com.cupk.pojo.ChuanChengRen;
import com.cupk.pojo.MingDan;
import com.cupk.service.MingDanService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:MingDanServiceImpl
 * 描述:清单中的名单里的service实现类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-29 18:36
 */
@Service
@Primary
public class MingDanServiceImpl implements MingDanService {
    @Autowired(required = false)
    private MingDanMapper mingDanMapper;
    @Override
    public List<MingDan> findAll(int page, int size) {
        page = Math.max(1, page);
        size = Math.max(1, size);
        PageHelper.startPage(page, size);
        return mingDanMapper.findAll((page - 1) * size, size);
    }

    @Override
    public int countPages(int size) {
        long count = mingDanMapper.count();
        return (int) Math.ceil((double) count / size);
    }

    @Override
    public int calculateTotalPages(int size) {
        long count = mingDanMapper.count();
        return (int) Math.ceil((double) count / size);
    }

    @Override
    public List<MingDan> findMingDanByStr(String searchStr) {
        return mingDanMapper.findMingDanByStr(searchStr);
    }
}
