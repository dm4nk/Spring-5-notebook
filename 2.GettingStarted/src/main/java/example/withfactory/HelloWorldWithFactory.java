package example.withfactory;

import common.api.MessageProvider;
import common.api.MessageRenderer;
import factory.MessageSupportFactory;

public class HelloWorldWithFactory {
    public static void main(String... args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
