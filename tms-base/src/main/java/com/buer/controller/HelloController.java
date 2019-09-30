package com.buer.controller;

import com.buer.dto.ReponseResult;
import com.buer.dto.ResultInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@ReponseResult
public class HelloController {
    @GetMapping("sayHello")
    public Object login() {
        return "HELLO";
    }

    @GetMapping("sayHello/{a}")
    public Object login1(@PathVariable() int a) {
        return a;
    }


        @GetMapping("sayHello/{a}/page")
    public Object login3(@PathVariable() int a) {
        return "a:"+a+"==========="+"路径:";
    }

    @RequestMapping("sayHello/{a}/{page}")
    public Object login2(@PathVariable int a,@PathVariable String page) {

        return "a:"+a+"==========="+"page:"+page;
    }
    @RequestMapping("hHello")
    public ResultInfo login2() {
        ArrayList retDate = new ArrayList<Object>();
        retDate.add("susecccc");
        ResultInfo r = new ResultInfo();
        r.setDate(retDate);
        return r;
    }

    @RequestMapping("hHello1")
    public ArrayList login4() {
        ArrayList retDate = new ArrayList<Object>();
        retDate.add("susecccc啊啊啊啊啊啊啊啊啊");
        return retDate;
    }


}
