package com.w.codeer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * Author: zhongzhu.wang
 * Date:2026/10/26 09:13
 */

@Configuration
public class PayGatewayConfiguration {


    @Bean
    public PayServiceGateway payServiceGateway(){

        RestClient restClient = RestClient.builder()
                .build();


        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();

        return httpServiceProxyFactory.createClient(PayServiceGateway.class);
    }
}
