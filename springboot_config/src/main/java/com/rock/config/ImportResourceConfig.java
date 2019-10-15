package com.rock.config;

import com.rock.service.ImportResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:表示该类为一个配置类
 */
@Configuration
public class ImportResourceConfig {

    /**
     * 将方法的返回值添加到容器中
     * 容器中组件的ID就是方法的名称
     * @return 需要注入的对象
     */
    @Bean
    public ImportResourceService importResourceService() {
        System.out.println("进入配置配置类方法");
        return new ImportResourceService();
    }
}
