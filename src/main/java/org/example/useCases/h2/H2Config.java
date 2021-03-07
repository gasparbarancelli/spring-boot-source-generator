package org.example.useCases.h2;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.example.adapters.TemplateAdapter;
import org.example.data.Property;
import org.example.data.Template;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;

/***
 * This class perform all the actions necessary to config h2 database
 */
public class H2Config {

    private static final String DEFAULT_APPLICATION_PROPERTIES_PATH = "application.properties";
    private static final String H2_TEMPLATE_PATH = "/templates/spring-boot/databases/h2.json";

    private final Log log;
    private final MavenProject mavenProject;

    public H2Config(final Log log, final MavenProject mavenProject) {
        this.log = log;
        this.mavenProject = mavenProject;
    }

    public void config() {
        this.log.info("Configuring H2 in default mode");

        final Template template = TemplateAdapter.findTemplate(H2_TEMPLATE_PATH);
        this.addDependencies(template);

        final boolean fileSuccessfullyUpdated = this.addApplicationPropertiesConfigs(template.getPropertyList());
        if (!fileSuccessfullyUpdated) {
            this.log.info("An error occurred trying to update your application.properties");
            return;
        }

        this.log.info("Your h2 is correctly configured and ready to use");
    }

    /***
     * This method will basically add all the necessary dependencies to the project
     * @param template that contains all the dependencies
     */
    private void addDependencies(final Template template) {
        this.log.info("Adding dependencies");

        final List<Dependency> mavenDependencyList = template.getMavenDependencyList();

        final Model model = this.mavenProject.getModel();
        for (Dependency dependency : mavenDependencyList) {
            model.addDependency(dependency);
        }
    }

    /***
     * This method will write all the needed configurations in the application.properties file
     * @param propertyList contains all the properties necessary to update application.properties
     */
    private boolean addApplicationPropertiesConfigs(final List<Property> propertyList) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        final URL resource = classLoader.getResource(H2Config.DEFAULT_APPLICATION_PROPERTIES_PATH);
        try {
            if (Objects.isNull(resource)) {
                this.log.info("Application property file not found");
                return false;
            }

            final URI uri = resource.toURI();
            final File applicationProperties = new File(uri);
            final FileWriter fileWriter = new FileWriter(applicationProperties);

            this.log.info("Writing application properties configs");
            for (Property property : propertyList) {
                fileWriter.append(property.toString()).append("\n");
            }

        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
