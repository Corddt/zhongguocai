package com.cupk.service.impl;

import com.cupk.mapper.CaiPuMapper;
import com.cupk.pojo.CaiPu;
import com.cupk.service.CaiPuService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称CaiPuServiceImpl
 * <p>
 * 描述
 *
 * @version 1.0
 * @author:ZhangChao
 * @datatime:2023-06-29 16:33
 */
@Service
@Primary
public class CaiPuServiceImpl implements CaiPuService {
    @Autowired(required=false)
    private CaiPuMapper caiPuMapper;

    @Override
    public CaiPu findCaiPuById(int id) {
        return caiPuMapper.findCaiPuById(id);
    }

    @Override
    public List<CaiPu> findAll(int page, int size) {
        page = Math.max(1, page);
        size = Math.max(1, size);
        PageHelper.startPage(page, size);
        return caiPuMapper.findAll((page - 1) * size, size);
    }

    @Override
    public int countPages(int size) {
        long count = caiPuMapper.count();
        return (int) Math.ceil((double) count / size);
    }

    @Override
    public int calculateTotalPages(int size) {
        long count = caiPuMapper.count();
        return (int) Math.ceil((double) count / size);
    }
}


