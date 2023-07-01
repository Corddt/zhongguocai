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
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/mingdan_findbystr")
    public String findMingDanByStr(@RequestParam(value = "searchStr") String searchStr,Model model){
        List<MingDan> mingDanList = mingDanService.findMingDanByStr(searchStr);

        // Calculate totalPages
        int totalPages = mingDanService.calculateTotalPages(3);

        model.addAttribute("mingdanlist",mingDanList);

        if (totalPages == 0) {
            totalPages = 1;
        }
        model.addAttribute("totalPages", totalPages);

        System.out.println("断点检测"+totalPages);
        return "web/qingdan/mingdan";
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

    //这是book推荐的页面
    @Autowired(required = false)
    private BookService bookService;

    //跳转到图书查询首页
    @RequestMapping("/bookindex")
    public String toIndex(){
        return "web/tushu/bookindex";//访问bookindex.html
    }

    //跳转到图书插入页面
    @RequestMapping("/toinsert")
    public String toInsert(){
        return "web/tushu/insertbook";//访问bookindex.html
    }

    //添加图书信息
    @RequestMapping("/insert")
    public String insertBook(Book book,Model model){
        System.out.println("新增图书信息: "+book);
        int i = bookService.insertBook(book);
        if(i > 0){
            List<Book> bookList=bookService.findAllBooks();
            model.addAttribute("blist",bookList);
            model.addAttribute("msg","添加图书信息成功");
            return "web/tushu/booklist";
        }else{
            return "public/false";
        }
    }

    //查询全部图书
    @RequestMapping("/findall")
    public String findAllBooks(Model model){
        List<Book> bookList = bookService.findAllBooks();
        System.out.println(bookList);
        model.addAttribute("blist",bookList);//存储全部图书信息
        return "web/tushu/booklist";
    }

    //根据图书编号查询图书
    @GetMapping("/findbyid")
    public Book findBookByID(@RequestParam(name = "id") Integer id){
        Book book = bookService.findBookByID(id);
        System.out.println(book);
        return book;
    }

    @RequestMapping("/deletebyid/{id}")
    public String deleteBookByID(@PathVariable("id") Integer id, Model model){
        int i = bookService.deleteBookByID(id);
        if(i > 0){
            List<Book> bookList=bookService.findAllBooks();
            model.addAttribute("blist",bookList);
            model.addAttribute("msg","删除图书信息成功");
            return "web/tushu/booklist";
        }else{
            return "public/false";
        }
    }

    //跳转到图书修改页面
    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Book book = bookService.findBookByID(id);
        model.addAttribute("book",book);
        return "zhongguocai/updatebook";
    }

    @RequestMapping("/update")
    public String updateBook(Book book,Model model){
        int i = bookService.updateBook(book);
        if(i > 0){
            List<Book> bookList=bookService.findAllBooks();
            model.addAttribute("blist",bookList);
            model.addAttribute("msg","修改图书信息成功");
            return "web/tushu/booklist";
        }else{
            return "public/false";
        }
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
