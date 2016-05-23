/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * @author Nilton Fernando
 */
@Configuration
@ComponentScan(basePackages = "core.com.spring.test")
@EnableAspectJAutoProxy

public class SpringMVCTestConfig extends WebMvcConfigurationSupport {

}
