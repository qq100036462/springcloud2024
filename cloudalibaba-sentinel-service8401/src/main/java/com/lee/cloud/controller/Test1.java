package com.lee.cloud.controller;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Test1 {
    Demo demo;
    public Test1(Demo demo){
        this.demo = demo;
    }

    @Transactional
    public void test1(){
        int i = 1/0;
    }
}
