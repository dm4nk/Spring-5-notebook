package com.dm4nk.common.impl;

import com.dm4nk.common.api.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello world";
    }
}
