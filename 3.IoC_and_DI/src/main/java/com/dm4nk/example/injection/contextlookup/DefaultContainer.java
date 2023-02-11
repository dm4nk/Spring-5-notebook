package com.dm4nk.example.injection.contextlookup;

import com.dm4nk.common.Constants;
import com.dm4nk.common.Dependency;

public class DefaultContainer implements Container {
    @Override
    public Object getDependency(String key) {
        if (Constants.DEPENDENCY.equals(key)) {
            return new Dependency();
        }

        throw new RuntimeException("Unknown dependency: " + key);
    }
}
