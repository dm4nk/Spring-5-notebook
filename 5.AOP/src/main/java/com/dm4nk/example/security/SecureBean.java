package com.dm4nk.example.security;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecureBean {
    public void writeSecureMessage() {
        log.debug("Every time I learn something new, "
                + "it pushes some old stuff out of my brain");
    }
}
