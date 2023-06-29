package com.cupk.service.impl;

import com.cupk.mapper.YingXiangMapper;
import com.cupk.pojo.YingXiang;
import com.cupk.service.YingXiangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:YingXiangServiceImpl
 * 描述:TuPianService的实现类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-29 10:17
 */
@Service
@Primary
public class YingXiangServiceImpl implements YingXiangService {
    @Autowired(required = false)
    private YingXiangMapper yingXiangMapper;
    @Override
    public List<YingXiang> findAllYingXiang() {
        return yingXiangMapper.findAllYingXiang();
    }
}
