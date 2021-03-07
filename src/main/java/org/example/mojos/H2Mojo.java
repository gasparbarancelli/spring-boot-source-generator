package org.example.mojos;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.example.useCases.h2.H2Config;

@Mojo(name = "config-h2", defaultPhase = LifecyclePhase.COMPILE)
public class H2Mojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject mavenProject;

    @Override
    public void execute() {
        final H2Config h2Config = new H2Config(getLog(), mavenProject);
        h2Config.config();
    }
}
