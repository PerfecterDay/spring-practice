package com.w.codeer;


import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * Author: zhongzhu.wang
 * Date:2026/10/26 09:10
 */

@HttpExchange
public interface PayServiceGateway {

    @GetExchange(url = "https://www.baidu.com")
    String index();
}
