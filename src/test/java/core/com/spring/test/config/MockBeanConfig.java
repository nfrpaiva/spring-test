/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.config;

import core.com.spring.test.spring.factory.EasyMockFactoryBean;
import core.com.spring.test.service.Service;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Nilton Fernando
 */
public class MockBeanConfig {

    @Bean(name = "serviceMock")
    public EasyMockFactoryBean<Service> getEasyMockFactoryBean() {
        return new EasyMockFactoryBean<>(Service.class);
    }
//
//    @Bean(name = "pessoaServiceImpl")
//    public EasyMockFactoryBean<PessoaService> getPessoaServiceFactoryBean() {
//        return new EasyMockFactoryBean<>(PessoaService.class);
//    }
}
