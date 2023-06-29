package com.cupk.controller;

import com.cupk.pojo.CaiPu;
import com.cupk.pojo.City;
import com.cupk.pojo.TuPian;
import com.cupk.pojo.YingXiang;
import com.cupk.service.CaiPuService;
import com.cupk.service.CityService;
import com.cupk.service.TuPianService;
import com.cupk.service.YingXiangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 名称:TuPianController
 * 描述:调用前端请求实现后端方法
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-28 18:30
 */
@Controller
@RequestMapping("/zhongguocai")
public class WebController {
    @Autowired(required = false)
    private TuPianService tuPianService;

    @RequestMapping("/tupian")
    public String findAllTuPian(Model model) {
        List<TuPian> tuPianList = tuPianService.findAllTuPian();
        for (TuPian tuPian : tuPianList)
            System.out.println(tuPian.getTimu() + " " + tuPian.getTupian() + " " + tuPian.getLaiyuan());
        model.addAttribute("tupianlist", tuPianList);//存储全部的图片信息
        return "web/tupian_ziyuan";
    }

    @Autowired(required = false)
    private YingXiangService yingXiangService;

    @RequestMapping("/yingxiang")
    public String findAllYingXiang(Model model) {
        List<YingXiang> yingXiangList = yingXiangService.findAllYingXiang();
        for (YingXiang yingXiang : yingXiangList)
            System.out.println(yingXiang.getTimu() + " " + yingXiang.getYingxiang() + " " + yingXiang.getShipinlaiyuan());
        model.addAttribute("yingxianglist", yingXiangList);//存储全部的影像信息
        return "web/yingxiang_ziyuan";
    }


    @Autowired(required = false)
    private CaiPuService caiPuService;

    @RequestMapping("/caipu")
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size) {

    List<CaiPu> caiPus =caiPuService.finaAll(page,size);
    model.addAttribute("caiPus",caiPus);
    return "index";
    }

    @Autowired(required = false)
    private CityService cityService;
    @RequestMapping("/city")
    public String findAllCity(Model model){
        List<City> cityList=cityService.findAllCity();
        for(City city:cityList)
            System.out.println(city.getMingcheng()+" "+city.getShijing()+" "+city.getTese()+" "+city.getLishi_year());
        model.addAttribute("citylist",cityList);
        return "web/city";
    }
}
