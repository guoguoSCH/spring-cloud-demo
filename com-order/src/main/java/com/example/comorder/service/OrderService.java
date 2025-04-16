package com.example.comorder.service;

import com.example.comorder.annctation.LogAnnotation;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @LogAnnotation(name = "沈陈晗", age = "20", sex = "男")
    public void queryOrder(){
        System.out.println("查询订单service");
    }
}
