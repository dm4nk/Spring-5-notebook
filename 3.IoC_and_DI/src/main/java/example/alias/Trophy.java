package example.alias;

import org.springframework.core.annotation.AliasFor;

/**
 * Created by iuliana.cosmina on 2/19/17.
 */

@Award
public @interface Trophy {

    @AliasFor(annotation = Award.class, attribute = "value")
    String[] name() default {};
}
