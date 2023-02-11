package com.dm4nk.common.impl;

import com.dm4nk.common.api.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello world";
    }
}
