/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.sprint.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * @author T802892
 */
@Configuration
@ComponentScan(basePackages = "core.com.spring.test")
public class SpringMVCTestConfig extends WebMvcConfigurationSupport{
    
}
