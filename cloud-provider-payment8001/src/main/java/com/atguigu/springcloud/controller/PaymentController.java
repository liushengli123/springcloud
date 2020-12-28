package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @PostMapping("/cloud/save")
    public CommonResult save(@RequestBody Payment payment){
        int i = paymentService.save(payment);
        log.info("*****插入数据: "+i);
        if (i > 0) {
            return new CommonResult(200, "向数据库添加成功。。。", i);
        }else {
            return new CommonResult(201,"向数据库添加数据失败。。。",null);
        }
    }
    @GetMapping("/cloud/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果: "+payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功。。。", payment);
        }else {
            return new CommonResult(201,"查询失败。。。",null);
        }
    }
}
