package org.example.data;

/***
 * Class that contains all the dependency information to be added in the project
 */
public class Dependency {

    private String groupId;
    private String artifactId;
    private String scope;

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getScope() {
        return scope;
    }

    public org.apache.maven.model.Dependency toMavenDependency() {
        final org.apache.maven.model.Dependency dependency = new org.apache.maven.model.Dependency();
        dependency.setGroupId(this.groupId);
        dependency.setScope(this.scope);
        dependency.setArtifactId(this.artifactId);
        return dependency;
    }
}
