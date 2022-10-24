package com.ywj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YaoWenJun
 * @date 2022/9/23 14:26
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRandomRule(){
        return new RandomRule(); // 随机
    }

}
