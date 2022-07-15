package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"common/impl"})
@Configuration
public class HelloWorldConfiguration {

}
