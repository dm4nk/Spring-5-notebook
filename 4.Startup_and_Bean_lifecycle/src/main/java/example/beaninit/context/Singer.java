package example.beaninit.context;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;

import static java.lang.constant.ConstantDescs.DEFAULT_NAME;

@Slf4j
@ToString
@Getter
@Setter
public class Singer {
    private String name;
    private int age = Integer.MIN_VALUE;

    public static Singer getBean(String beanName, ApplicationContext ctx) {
        try {
            Singer bean = (Singer) ctx.getBean(beanName);
            log.debug(bean.toString());
            return bean;
        } catch (BeanCreationException ex) {
            log.debug("An error occurred in bean configuration: " + ex.getMessage());
            return null;
        }
    }

    private void init() {
        log.debug("Initializing bean via configuration");

        if (name == null) {
            log.debug("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " + Singer.class);
        }
    }
}
