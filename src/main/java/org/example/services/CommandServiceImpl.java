package org.example.services;

public class CommandServiceImpl implements CommandService {

    @Override
    public String listAllCommands() {
        return getTemplateCommandHelper("help", "list all the possible commands");
    }

    private String getTemplateCommandHelper(final String command, final String description) {
        return String.format("%s      %s", command, description);
    }
}
