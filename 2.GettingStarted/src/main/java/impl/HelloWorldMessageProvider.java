package impl;

import api.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello world";
    }
}
