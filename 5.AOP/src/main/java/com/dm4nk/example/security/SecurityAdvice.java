package com.dm4nk.example.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if (user == null) {
            log.debug("No user authenticated");
            throw new SecurityException(
                    "You must login before attempting to invoke the method: "
                            + method.getName());
        } else if ("John".equals(user.userName())) {
            log.debug("Logged in user is John - OKAY!");
        } else {
            log.debug("Logged in user is " + user.userName()
                    + " NOT GOOD :(");
            throw new SecurityException("User " + user.userName()
                    + " is not allowed access to method " + method.getName());
        }
    }
}
