package com.dm4nk.example.alias;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by iuliana.cosmina on 2/19/17.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Award {

    @AliasFor("prize")
    String[] value() default {};

    @AliasFor("value")
    String[] prize() default {};
}
