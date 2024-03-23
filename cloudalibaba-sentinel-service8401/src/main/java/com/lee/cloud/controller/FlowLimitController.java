package com.lee.cloud.controller;

import com.lee.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController
{

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    /**流控-链路演示demo
     * C和D两个请求都访问flowLimitService.common()方法，阈值到达后对C限流，对D不管
     */
    @Resource
    private FlowLimitService flowLimitService;
    @GetMapping("/testC")
    public String testC()
    {
        flowLimitService.common();
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD()
    {
        flowLimitService.common();
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        System.out.println(System.currentTimeMillis());
        return "------testE";
    }

    @GetMapping("/testF")
    public String testF()
    {
        System.out.println(System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "------testF   熔断慢调用";
    }

    @Autowired
    Test1 test1;
    @GetMapping("/testG")
    public String testG()
    {
        Demo demo = test1.demo;
        return "------testG";
    }

}


