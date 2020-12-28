package com.atguigu.speingcloud.controller;

import com.atguigu.speingcloud.entity.CommonResult;
import com.atguigu.speingcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/cloud/save")
    public CommonResult<Payment> save(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/cloud/save",payment,CommonResult.class);
    }

    @GetMapping("/consumer/cloud/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/cloud/get/"+id,CommonResult.class);
    }
}
