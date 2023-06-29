package com.cupk.service.impl;

import com.cupk.mapper.MingDanMapper;
import com.cupk.pojo.MingDan;
import com.cupk.service.MingDanService;
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
    public List<MingDan> findAllMingDan() {
        return mingDanMapper.findAllMingDan();
    }
}
