package example.withmessageproviders;

import common.api.MessageProvider;
import common.api.MessageRenderer;
import common.impl.HelloWorldMessageProvider;
import common.impl.StandardOutMessageRenderer;

public class HelloWorldWithMessageProviders {
    public static void main(String... args) {
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        MessageRenderer messageRenderer = new StandardOutMessageRenderer(messageProvider);
        messageRenderer.render();
    }
}
