package org.example.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that parse the template file in the resource
 */
public class Template {
    private List<Dependency> dependencyList;
    private List<Property> propertyList;

    public List<org.apache.maven.model.Dependency> getMavenDependencyList() {
        final List<org.apache.maven.model.Dependency> mavenDependencies = new ArrayList<>();
        for (Dependency dependency : dependencyList) {
            final org.apache.maven.model.Dependency mavenDependency = dependency.toMavenDependency();
            mavenDependencies.add(mavenDependency);
        }
        return mavenDependencies;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }
}
