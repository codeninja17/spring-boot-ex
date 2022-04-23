package com.example.boot.models;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@PropertySource("classpath:/mail.properties")
public class Employee {

    @Value("${test.mail}")
    private String name;
    private Integer id ;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Post Construct called");
        System.out.println(this.name);
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Pre destruct called");
    }
}
