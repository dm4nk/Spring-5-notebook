package com.dm4nk.example.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dm4nk"})
public class AspectJAnnotationDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AspectJAnnotationDemo.class, args);
        assert (ctx != null);

        NewDocumentarist documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
        documentarist.execute();

        ctx.close();
    }
}
