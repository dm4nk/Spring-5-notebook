package example.injection.simple;

import common.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
    @Value("#{injectSimpleConstants.name}")
    private String name;

    @Value("#{injectSimpleConstants.age + 1}")
    private int age;

    @Value("#{injectSimpleConstants.height}")
    private float height;

    @Value("#{injectSimpleConstants.programmer}")
    private boolean programmer;

    @Value("#{injectSimpleConstants.ageInSeconds}")
    private Long ageInSeconds;

    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectSimpleConfig.class);
        InjectSimpleSpel simple = ctx.getBean(Constants.INJECT_SIMPLE_SPEL, InjectSimpleSpel.class);
        System.out.println(simple);
    }

    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }
}
