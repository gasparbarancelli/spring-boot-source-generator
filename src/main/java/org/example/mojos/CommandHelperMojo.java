package org.example.mojos;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.example.services.CommandService;
import org.example.services.CommandServiceImpl;

@Mojo(name = "list-commands", defaultPhase = LifecyclePhase.COMPILE)
public class CommandHelperMojo extends AbstractMojo {

    private CommandService commandService = new CommandServiceImpl();

    public void execute() {
        final String allCommands = commandService.listAllCommands();
        getLog().info(allCommands);
    }
}
