package factory;

import common.api.MessageProvider;
import common.api.MessageRenderer;
import lombok.Getter;

import java.util.Properties;

@Getter
public class MessageSupportFactory {
    @Getter
    private static final MessageSupportFactory instance = new MessageSupportFactory();
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        Properties props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/factory.properties"));
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(rendererClass)
                    .getDeclaredConstructor()
                    .newInstance();
            provider = (MessageProvider) Class.forName(providerClass)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
