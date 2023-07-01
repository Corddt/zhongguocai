package com.cupk.controller;

/**
 * 名称:LoginController
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-07-02 00:47
 */
import com.cupk.Database;
import com.cupk.pojo.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@RestController
public class LoginController {

    @Autowired(required = false)
    Database database;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Userdata user = null;
        try {
            user = database.check(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            // 登录成功，跳转到主页
            return new ModelAndView("redirect:/zhongguocai/bookindex");
        } else {
            // 登录失败，返回错误信息
            return new ModelAndView("redirect:/zhongguocai/login");
        }
    }
}


