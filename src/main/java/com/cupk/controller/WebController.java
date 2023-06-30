package com.cupk.controller;

import com.cupk.pojo.*;
import com.cupk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    //资源中的图片子页面
    @Autowired(required = false)
    private TuPianService tuPianService;

    @RequestMapping("/tupian")
    public String findAllTuPian(Model model) {
        List<TuPian> tuPianList = tuPianService.findAllTuPian();
        for (TuPian tuPian : tuPianList)
            System.out.println(tuPian.getTimu() + " " + tuPian.getTupian() + " " + tuPian.getLaiyuan());
        model.addAttribute("tupianlist", tuPianList);//存储全部的图片信息
        return "web/ziyuan/tupian_ziyuan";
    }


    //资源中的影像子页面
    @Autowired(required = false)
    private YingXiangService yingXiangService;

    @RequestMapping("/yingxiang")
    public String findAllYingXiang(Model model) {
        List<YingXiang> yingXiangList = yingXiangService.findAllYingXiang();
        for (YingXiang yingXiang : yingXiangList)
            System.out.println(yingXiang.getTimu() + " " + yingXiang.getYingxiang() + " " + yingXiang.getShipinlaiyuan());
        model.addAttribute("yingxianglist", yingXiangList);//存储全部的影像信息
        return "web/ziyuan/yingxiang_ziyuan";
    }


    //这是清单中的菜谱子页面
    @Autowired(required = false)
    private CaiPuService caiPuService;

    @RequestMapping("/caipu")
    public String caipufenye(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "3") int size) {

        page = Math.max(1, page);
        size = Math.max(1, size);
        int totalPages = caiPuService.countPages(size);
        List<CaiPu> caiPuList = caiPuService.findAll(page, size);
        model.addAttribute("caiPus", caiPuList);

        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        return "web/qingdan/caipu";
    }

    //这是清单里面的传承人子页面
    @Autowired(required = false)
    private ChuanChengRenService chuanChengRenService;

    @RequestMapping("/chuanchengren")
    public String chuanchengren(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "3") int size) {

        page = Math.max(1, page);
        size = Math.max(1, size);
        int totalPages = chuanChengRenService.countPages(size);
        List<ChuanChengRen> chuanChengRenList = chuanChengRenService.findAll(page, size);
        model.addAttribute("chuanchengrenlist", chuanChengRenList);

        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        return "web/qingdan/chuanchengren";
    }



    //清单中的城市子页面
    @Autowired(required = false)
    private CityService cityService;

    @RequestMapping("/chengshi")
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        for (City city : cityList)
            System.out.println(city.getMingcheng() + " " + city.getShijing() + " " + city.getTese() + " " + city.getLishi_year());
        model.addAttribute("citylist", cityList);
        return "web/qingdan/city";
    }


    //这是清单里面的名单子页面
    @Autowired(required = false)
    private MingDanService mingDanService;

    @RequestMapping("/mingdan")
    public String mingdan(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "3") int size) {

        page = Math.max(1, page);
        size = Math.max(1, size);
        int totalPages = mingDanService.countPages(size);
        List<MingDan> mingDanList = mingDanService.findAll(page, size);
        model.addAttribute("mingdanlist", mingDanList);

        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        return "web/qingdan/mingdan";
    }

    @GetMapping("/zhongguocai/mingdan/search")
    public String search(@RequestParam String keyword, Model model) {
        List<MingDan> result = mingDanService.search(keyword);
        model.addAttribute("mingdanlist", result);
        return "mingdan";
    }

    //这是清单里面的食材子页面
    @Autowired(required = false)
    private ShiCaiService shiCaiService;

    @RequestMapping("/shicai")
    public String shicai(Model model,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "3") int size) {

        page = Math.max(1, page);
        size = Math.max(1, size);
        int totalPages = shiCaiService.countPages(size);
        List<ShiCai> shiCaiList = shiCaiService.findAll(page, size);
        model.addAttribute("shicailist", shiCaiList);

        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        return "web/qingdan/shicai";
    }

    //这是资源里面的H5赏析子页面
    @RequestMapping("/h5")
    public String h5() {
        return "web/ziyuan/H5_ziyuan";
    }

    @RequestMapping("/index")
    public String index(){
        return "首页";
    }
    @RequestMapping("/info")
    public String info(){
        return "web/zixun/info";
    }
    @RequestMapping("/info_news")
    public String info_news(){
        return "web/zixun/info_news";
    }
    @RequestMapping("/info_notification")
    public String info_notification(){
        return "web/zixun/info_notification";
    }
    @RequestMapping("/info_reports")
    public String info_reports(){
        return "web/zixun/info_reports";
    }

}
