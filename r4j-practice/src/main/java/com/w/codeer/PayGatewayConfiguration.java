package com.w.codeer;


import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
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
    public PayServiceGateway payServiceGateway(CircuitBreakerFactory cf){

        RestClient restClient = RestClient.builder()
                .build();


        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();

        PayServiceGateway client = httpServiceProxyFactory.createClient(PayServiceGateway.class);
        CircuitBreaker circuitBreaker = cf.create("aaa", "bbb");

        return client;
//        return circuitBreaker.run(client::index, t -> "fallback: " + t.getMessage());
    }
}
