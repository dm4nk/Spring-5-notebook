package com.dm4nk.example.configurablecomponent;

import com.dm4nk.common.Constants;
import com.dm4nk.common.Files;
import com.dm4nk.common.api.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(Files.CONFIGURABLE_CTX);
        ctx.refresh();

        MessageProvider messageProvider = ctx.getBean(Constants.PROVIDER, MessageProvider.class);

        System.out.println(messageProvider.getMessage());
        ctx.close();
    }
}
