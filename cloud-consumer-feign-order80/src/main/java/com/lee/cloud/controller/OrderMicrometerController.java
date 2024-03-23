package com.lee.cloud.controller;

import com.lee.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试链路追踪 micrometer代替Sleuth
 */
@RestController
@Slf4j
public class OrderMicrometerController
{
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id)
    {
        return payFeignApi.myMicrometer(id);
    }
}
