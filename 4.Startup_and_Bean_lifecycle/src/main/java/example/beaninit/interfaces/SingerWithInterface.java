package example.beaninit.interfaces;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static common.Constants.*;
import static common.Constants.SINGER_THREE;
import static common.Files.INTERFACES;

public class SingerWithInterface implements InitializingBean {

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void afterPropertiesSet() {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " 
                    + SingerWithInterface.class);
        }
    }

    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(INTERFACES);
        ctx.refresh();

        getBean(SINGER_ONE, ctx);
        getBean(SINGER_TWO, ctx);
        getBean(SINGER_THREE, ctx);

        ctx.close();
    }

    private static SingerWithInterface getBean(String beanName,
            ApplicationContext ctx) {
        try {
            SingerWithInterface bean = (SingerWithInterface) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occurred in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }
}
