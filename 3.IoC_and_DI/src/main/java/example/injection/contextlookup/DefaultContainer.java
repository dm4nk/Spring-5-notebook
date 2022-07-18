package example.injection.contextlookup;

import common.Constants;
import common.Dependency;

public class DefaultContainer implements Container {
    @Override
    public Object getDependency(String key) {
        if (Constants.DEPENDENCY.equals(key)) {
            return new Dependency();
        }

        throw new RuntimeException("Unknown dependency: " + key);
    }
}
