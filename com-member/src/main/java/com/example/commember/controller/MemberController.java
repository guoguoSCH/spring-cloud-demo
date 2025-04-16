package com.example.commember.controller;


import com.example.commember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MemberController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MemberService memberService;

    @RequestMapping("/queryOrder")
    public String queryOrder(){
        String url = "http://com-order/queryOrder";
        memberService.queryMember();
        return restTemplate.getForObject(url, String.class);
    }

    @RequestMapping("/queryMember")
    public String queryMember(){
        memberService.queryMember();
        return "调用成功";
    }
}
