package com.rock.config;

import com.rock.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:表示该类为一个配置类
 */
@Configuration
public class TestConfig {

    /**
     * 注入的名称就是方法的名称
     * @return 需要注入的对象
     */
    @Bean
    public TestService testService() {
        System.out.println("进入配置配置类方法");
        return new TestService();
    }
}
