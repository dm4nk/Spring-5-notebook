package common.impl;

import common.api.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello world";
    }
}
