package com.example.boot.configurations;

import com.example.boot.service.EmployeeService;
import com.example.boot.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:/mail.properties")
public class CustomPropertySource {

    @Bean
    @Scope("singleton")
    // @Scope("prototype")
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Profile("qa")
    public EmployeeService employeeService(){
        System.out.println("Employee Service returned");
        return new EmployeeServiceImpl();
    }

    @Bean
    @Profile("dev")
    public EmployeeService employeeServiceDev(){
        System.out.println("Employee Service Dev returned");
        return new EmployeeServiceImpl();
    }

}
