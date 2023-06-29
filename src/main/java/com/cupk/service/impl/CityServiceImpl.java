package com.cupk.service.impl;

import com.cupk.mapper.CityMapper;
import com.cupk.pojo.City;
import com.cupk.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:CityServiceImpl
 * 描述:CityService的实现类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-29 17:16
 */
@Service
@Primary
public class CityServiceImpl implements CityService {
    @Autowired(required = false)
    private CityMapper cityMapper;
    @Override
    public List<City> findAllCity() {
        return cityMapper.findAllCity();
    }
}
