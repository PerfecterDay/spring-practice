package com.w.codeer;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zhongzhu.wang
 * Date:2026/10/26 09:09
 */

@RestController
public class TestController {

    @Resource
    PayServiceGateway payServiceGateway;

    @GetMapping("/")
    public String pay(){
        return payServiceGateway.index();
    }
}
