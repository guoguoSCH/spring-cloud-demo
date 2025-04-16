package com.example.commember.service;

import com.example.commember.anotation.LogAnnotation;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @LogAnnotation(age = "18", name = "沈陈晗", sex = "男")
    public void queryMember(){
        System.out.println("开始查询会员");
    }
}
