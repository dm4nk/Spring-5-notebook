package com.dm4nk.example.injection.constructorinjection;

import com.dm4nk.common.Dependency;

public class ConstructorInjection {

    private Dependency dependency;

    public ConstructorInjection(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
