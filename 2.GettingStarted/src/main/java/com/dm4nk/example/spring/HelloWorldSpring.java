package com.dm4nk.example.spring;

import com.dm4nk.common.api.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpring {
    private final static String CONTEXT_FILE = "context.xml";

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(CONTEXT_FILE);
        MessageRenderer mr = ctx.getBean(MessageRenderer.class);
        mr.render();
    }
}
