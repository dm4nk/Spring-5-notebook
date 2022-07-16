package example.injection.contextlookup;

import common.Constants;
import common.Dependency;

public class ContextualizedDependencyLookup implements ManagedComponent{
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
