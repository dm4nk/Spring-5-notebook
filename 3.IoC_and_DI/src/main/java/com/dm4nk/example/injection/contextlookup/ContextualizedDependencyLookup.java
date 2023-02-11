package com.dm4nk.example.injection.contextlookup;

import com.dm4nk.common.Constants;
import com.dm4nk.common.Dependency;

public class ContextualizedDependencyLookup implements ManagedComponent {
    private Dependency dependency;

    @Override
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency(Constants.DEPENDENCY);
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
