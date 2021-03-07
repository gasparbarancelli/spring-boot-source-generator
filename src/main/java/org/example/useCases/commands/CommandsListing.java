package org.example.useCases.commands;

/***
 * This class will be used for listing the possible commands
 */
public class CommandsListing {

    public String listAllCommands() {
        return getTemplateCommandHelper("help", "list all the possible commands");
    }

    private String getTemplateCommandHelper(final String command, final String description) {
        return String.format("%s      %s", command, description);
    }

}
