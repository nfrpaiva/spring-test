package core.com.spring.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import core.com.spring.PersistenceJPAConfig;

/**
 * @author Nilton Fernando
 */
@Configuration
@ComponentScan(basePackages = "core.com.spring.test")
@EnableAspectJAutoProxy
@Import(value=PersistenceJPAConfig.class)
public class SpringMVCTestConfig extends WebMvcConfigurationSupport {

}
