package com.cupk.service.impl;

import com.cupk.mapper.CaiPuMapper;
import com.cupk.pojo.CaiPu;
import com.cupk.service.CaiPuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
    public List<CaiPu> findCaiPuById(int id) {
        return caiPuMapper.findCaiPuById(id);
    }

    @Override
    public List<CaiPu> finaAll(int page,int size) {
        return caiPuMapper.finaAll(page,size);
    }

    @Override
    public int countPages(int size) {
        int total= caiPuMapper.count();
        return (total+size-1)/size;
    }

}
