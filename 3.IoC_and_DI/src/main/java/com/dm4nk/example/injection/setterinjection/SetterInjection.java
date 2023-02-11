package com.dm4nk.example.injection.setterinjection;

import com.dm4nk.common.Dependency;

public class SetterInjection {

    private Dependency dependency;

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
