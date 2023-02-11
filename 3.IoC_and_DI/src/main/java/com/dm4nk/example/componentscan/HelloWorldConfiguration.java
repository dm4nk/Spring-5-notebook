package com.dm4nk.example.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"common/impl"})
@Configuration
public class HelloWorldConfiguration {

}
