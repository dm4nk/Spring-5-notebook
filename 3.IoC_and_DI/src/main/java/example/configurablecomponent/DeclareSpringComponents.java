package example.configurablecomponent;

import common.Constants;
import common.api.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:context-for-configurable-component.xml");
        ctx.refresh();

        MessageProvider messageProvider = ctx.getBean(Constants.PROVIDER, MessageProvider.class);

        System.out.println(messageProvider.getMessage());
        ctx.close();
    }
}
