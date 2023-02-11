package com.dm4nk.example.annotatedconfiguration;

import com.dm4nk.common.api.MessageRenderer;
import com.dm4nk.config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldWithAnnotatedConfiguration {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (AppConfiguration.class);
        MessageRenderer mr = ctx.getBean(MessageRenderer.class);
        mr.render();
    }
}
