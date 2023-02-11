package com.dm4nk.example.beaninit.annotation;

import com.dm4nk.example.beaninit.context.Singer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

import static com.dm4nk.common.Constants.*;

@Slf4j
@ToString
@Getter
@Setter
public class SingerWithAnnotation {
    private static final String DEFAULT_NAME = "Eric Clapton";

    private String name;
    private int age = Integer.MIN_VALUE;

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);

        getBean(SINGER_ONE, ctx);
        getBean(SINGER_TWO, ctx);
        getBean(SINGER_THREE, ctx);

        ctx.close();
    }

    private static SingerWithAnnotation getBean(String beanName, ApplicationContext ctx) {
        try {
            SingerWithAnnotation bean = (SingerWithAnnotation) ctx.getBean(beanName);
            log.debug(bean.toString());
            return bean;
        } catch (BeanCreationException ex) {
            log.debug("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }

    @PostConstruct
    private void init() {
        log.debug("Initializing bean via @PostConstruct");

        if (name == null) {
            log.debug("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " +
                            SingerWithAnnotation.class);
        }
    }

    @Configuration
    @NoArgsConstructor
    private static class SingerConfig {

        @Lazy
        @Bean(name = SINGER_ONE, initMethod = "init")
        Singer singerOne() {
            Singer singerOne = new Singer();
            singerOne.setName("John Mayer");
            singerOne.setAge(39);
            return singerOne;
        }

        @Lazy
        @Bean(name = SINGER_TWO, initMethod = "init")
        Singer singerTwo() {
            Singer singerTwo = new Singer();
            singerTwo.setAge(72);
            return singerTwo;
        }

        @Lazy
        @Bean(name = SINGER_THREE, initMethod = "init")
        Singer singerThree() {
            Singer singerThree = new Singer();
            singerThree.setName("John Butler");
            return singerThree;
        }
    }
}
