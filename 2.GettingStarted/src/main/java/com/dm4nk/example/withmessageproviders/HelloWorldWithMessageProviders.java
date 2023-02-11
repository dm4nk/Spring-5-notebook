package com.dm4nk.example.withmessageproviders;

import com.dm4nk.common.api.MessageProvider;
import com.dm4nk.common.api.MessageRenderer;
import com.dm4nk.common.impl.StandardOutMessageRenderer;
import com.dm4nk.common.impl.HelloWorldMessageProvider;

public class HelloWorldWithMessageProviders {
    public static void main(String... args) {
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        MessageRenderer messageRenderer = new StandardOutMessageRenderer(messageProvider);
        messageRenderer.render();
    }
}
