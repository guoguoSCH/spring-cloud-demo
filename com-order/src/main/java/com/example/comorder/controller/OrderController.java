package com.example.comorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("queryOrder")
    public String queryOrder(){
        System.out.println("正在获取订单信息...");
        return "获取成功";
    }

    @RequestMapping("queryMember")
    public String queryMember(){
        String url = "http://com-member/queryMember";
        restTemplate.getForObject(url, String.class);
        return "获取会员信息成功";
    }
}
