/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.sprint.test;

import core.com.spring.test.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author fernando
 */
@Configuration
public class BeanConfig {

    @Bean(name = "serviceMock")
    public EasyMockFactoryBean getEasyMockFactoryBean() {
        return new EasyMockFactoryBean(Service.class);
    }

}
