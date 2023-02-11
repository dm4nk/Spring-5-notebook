package com.dm4nk.config;

import com.dm4nk.common.api.MessageProvider;
import com.dm4nk.common.api.MessageRenderer;
import com.dm4nk.common.impl.HelloWorldMessageProvider;
import com.dm4nk.common.impl.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
