package org.example.mojos;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.example.useCases.commands.CommandsListing;

@Mojo(name = "list-commands", defaultPhase = LifecyclePhase.COMPILE)
public class CommandHelperMojo extends AbstractMojo {

    public void execute() {
        final CommandsListing commands = new CommandsListing();
        getLog().info(commands.listAllCommands());
    }
}
