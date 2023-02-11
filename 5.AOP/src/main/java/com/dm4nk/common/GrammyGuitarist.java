package com.dm4nk.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("johnMayer")
public class GrammyGuitarist implements Singer {

    @Override
    public void sing() {
        log.debug("sing: Gravity is working against me; And gravity wants to bring me down");
    }

    public void sing(Guitar guitar) {
        log.debug("play: " + guitar.play());
    }

    public void rest() {
        log.debug("zzz");
    }

    public void talk() {
        log.debug("talk");
    }
}