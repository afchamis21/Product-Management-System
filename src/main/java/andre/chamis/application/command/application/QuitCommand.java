package andre.chamis.application.command.application;

import andre.chamis.application.command.Command;

public class QuitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Parando o programa");
        System.exit(0);
    }
}
