package com.cupk.controller;

import com.cupk.pojo.TuPian;
import com.cupk.pojo.YingXiang;
import com.cupk.service.TuPianService;
import com.cupk.service.YingXiangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class WebController {
    @Autowired(required = false)
    private TuPianService tuPianService;
    @RequestMapping("/tupian")
    public String findAllTuPian(Model model){
        List<TuPian> tuPianList=tuPianService.findAllTuPian();
        for(TuPian tuPian:tuPianList)
            System.out.println(tuPian.getTimu()+" "+tuPian.getTupian()+" "+tuPian.getLaiyuan());
        model.addAttribute("tupianlist",tuPianList);//存储全部的图片信息
        return "web/tupian_ziyuan";
    }
    @Autowired(required = false)
    private YingXiangService yingXiangService;
    @RequestMapping("/yingxiang")
    public String findAllYingXiang(Model model){
        List<YingXiang> yingXiangList=yingXiangService.findAllYingXiang();
        for(YingXiang yingXiang:yingXiangList)
            System.out.println(yingXiang.getTimu()+" "+yingXiang.getYingxiang()+" "+yingXiang.getShipinlaiyuan());
        model.addAttribute("yingxianglist",yingXiangList);//存储全部的影像信息
        return "web/yingxiang_ziyuan";
    }
}
