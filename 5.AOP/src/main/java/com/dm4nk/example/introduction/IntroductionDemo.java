package com.dm4nk.example.introduction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class IntroductionDemo {
    public static void main(String... args) {
        Contact target = new Contact();
        target.setName("John Mayer");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        Contact proxy = (Contact) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        log.debug("Is Contact?: {}", (proxy instanceof Contact));
        log.debug("Is IsModified?: {}", (proxy instanceof IsModified));

        log.debug("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("John Mayer");

        log.debug("Has been modified?: {}", proxyInterface.isModified());

        proxy.setName("Eric Clapton");

        log.debug("Has been modified?: {}", proxyInterface.isModified());
    }
}
