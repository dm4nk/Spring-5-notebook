package helloworld.annotatedconfiguration;

import api.MessageRenderer;
import config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldWithAnnotatedConfiguration {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (AppConfiguration.class);
        MessageRenderer mr = ctx.getBean( MessageRenderer.class);
        mr.render();
    }
}
