package com.cupk.service.impl;

import com.cupk.mapper.TuPianMapper;
import com.cupk.pojo.TuPian;
import com.cupk.service.TuPianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:TuPianServiceImpl
 * 描述:TuPianService的实现类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-28 18:27
 */

@Service
@Primary
public class TuPianServiceImpl implements TuPianService {
    @Autowired(required = false)
    private TuPianMapper tuPianMapper;
    @Override
    public List<TuPian> findAllTuPian() {
        return tuPianMapper.findAllTuPian();
    }
}
