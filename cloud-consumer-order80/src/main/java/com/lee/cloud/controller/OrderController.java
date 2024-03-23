package com.lee.cloud.controller;

import com.lee.cloud.entity.PayDTO;
import com.lee.cloud.utils.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {
     //public static final String payment_url = "http://localhost:8001";
     public static final String payment_url = "http://cloud-payment-service";

     @Resource
    private RestTemplate restTemplate;

     @PostMapping(value = "/pay/add")
     public ResultData addOrder(@RequestBody PayDTO payDTO)
    {
        ResultData resultData = restTemplate.postForObject(payment_url + "/pay/add", payDTO, ResultData.class);
        return ResultData.success(resultData);
    }
    @GetMapping(value = "/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id")Integer id)
    {
        ResultData resultData = restTemplate.getForObject(payment_url + "/pay/get/"+id, ResultData.class);
        return ResultData.success(resultData.getData());
    }
    @GetMapping(value = "/pay/getInfo")
    public ResultData getInfo()
    {
        ResultData resultData = restTemplate.getForObject(payment_url + "/pay/getInfo", ResultData.class);
        return ResultData.success(resultData.getData());
    }
}
