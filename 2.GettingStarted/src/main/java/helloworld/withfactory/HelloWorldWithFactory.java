package helloworld.withfactory;

import api.MessageProvider;
import api.MessageRenderer;
import factory.MessageSupportFactory;

public class HelloWorldWithFactory {
    public static void main(String... args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
