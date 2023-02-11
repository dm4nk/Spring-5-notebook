package com.dm4nk.example.alias;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by iuliana.cosmina on 2/19/17.
 */
public class AliasDemo {

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AliasBeanConfig.class);
        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);
        beans.forEach((k, v) -> System.out.println(
                "id: " + k + "\n aliases: " + Arrays.toString(ctx.getAliases(k)) + "\n")
        );
        ctx.close();
    }

    @Configuration
    static class AliasBeanConfig {
        //@Bean(name="johnMayer")
        //@Bean(name = "jon johnny,jonathan;jim")
        @Bean(name = {"johnMayer", "john", "jonathan", "johnny"})
        public Singer singer() {
            return new Singer();
        }
    }
}
