package com.buer.controller;/**
 * Created by yuhaining on 2019/9/23.
 */

import com.huaxin.cloud.tms.base.config.PasswordHelper;
import com.buer.entity.UserEntity;
import com.buer.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName:HomeController
 * @Author:yuhaining
 * @Date:2019/9/23
 */
enum Col{
    red("红色"),
    yellow("黄色");

    private String c;

    private Col(String clo){
        c = clo;
    }

    @Override
    public String toString() {
        return c;
    }
}

@RestController
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHelper passwordHelper;

    @GetMapping("login")
    public Object login() {
        return "Here is login page";
    }

    @GetMapping("unauthc")
    public Object unauthc() {
        return "Here is Unauthc page";
    }

    @GetMapping("targetUrl")
    public Object targetUrl() {
        return "targetUrl";
    }

    @GetMapping("doLogin")
    public Object doLogin(@RequestParam String username, @RequestParam String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            token.setRememberMe(true);
        } catch (IncorrectCredentialsException ice) {
            return "password error!";
        } catch (UnknownAccountException uae) {
            return "username error!";
        }
        UserEntity user = userService.getUserByName(username);
        subject.getSession().setAttribute("user", user);
        return "";
    }

    @GetMapping("register")
    public Object register(@RequestParam String username, @RequestParam String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        passwordHelper.encryptPassword(user);
        int i = userService.saveUser(user);
        return i > 0 ? "SUCCESS" : "ERROR";

    }


    @RequestMapping("/logout")
    public String logout(UserEntity loginUser){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "已注销";
    }
}
