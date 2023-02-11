package com.dm4nk.example.withfactory;

import com.dm4nk.common.api.MessageProvider;
import com.dm4nk.common.api.MessageRenderer;
import com.dm4nk.factory.MessageSupportFactory;

public class HelloWorldWithFactory {
    public static void main(String... args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
