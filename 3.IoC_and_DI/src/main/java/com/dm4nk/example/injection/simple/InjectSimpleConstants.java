package com.dm4nk.example.injection.simple;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component("injectSimpleConstants")
@Getter
@Setter
public class InjectSimpleConstants {
    private String name = "John Mayer";
    private int age = 40;
    private float height = 1.92f;
    private boolean programmer = false;
    private Long ageInSeconds = 1_241_401_112L;
}
