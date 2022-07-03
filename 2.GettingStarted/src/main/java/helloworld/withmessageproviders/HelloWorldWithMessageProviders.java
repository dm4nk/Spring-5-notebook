package helloworld.withmessageproviders;

import api.MessageProvider;
import api.MessageRenderer;
import impl.HelloWorldMessageProvider;
import impl.StandardOutMessageRenderer;

public class HelloWorldWithMessageProviders {
    public static void main(String... args){
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        MessageRenderer messageRenderer = new StandardOutMessageRenderer(messageProvider);
        messageRenderer.render();
    }
}
