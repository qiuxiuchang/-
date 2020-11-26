package com.atguigu.springcloud.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
       int result= paymentService.create(payment);

       if(result > 0){
           return new CommonResult(200,"插入数据成功",result);
       }else{
           return new CommonResult(444,"插入数据失败",result);
       }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);
        System.out.print(payment);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(444,"没有对应的数据",null);
        }

    }

}
