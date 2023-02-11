package com.dm4nk.example.componentscan;

import com.dm4nk.common.Constants;
import com.dm4nk.common.api.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldWithComponentScan {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean(Constants.RENDERER, MessageRenderer.class);
        mr.render();
    }
}
