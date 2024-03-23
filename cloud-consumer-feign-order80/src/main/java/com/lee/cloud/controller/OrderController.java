package com.lee.cloud.controller;

import com.lee.cloud.apis.PayFeignApi;
import com.lee.cloud.entity.PayDTO;
import com.lee.cloud.utils.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class OrderController {
     //public static final String payment_url = "http://localhost:8001";
     //public static final String payment_url = "http://cloud-payment-service";

     @Resource
     private PayFeignApi payFeignApi;

     @PostMapping(value = "/pay/add")
     public ResultData addOrder(@RequestBody PayDTO payDTO)
    {
        ResultData resultData = payFeignApi.addPay(payDTO);
        return ResultData.success(resultData);
    }
    @GetMapping(value = "/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id")Integer id)
    {
        ResultData resultData = payFeignApi.getPayInfo(id);
        return ResultData.success(resultData.getData());
    }
    @GetMapping(value = "/pay/getInfo")
    public ResultData getInfo()
    {
        ResultData resultData = payFeignApi.mylb();
        return ResultData.success(resultData.getData());
    }
}
