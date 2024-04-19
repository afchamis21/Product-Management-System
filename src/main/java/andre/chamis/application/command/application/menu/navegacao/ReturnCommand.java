package andre.chamis.application.command.application.menu.navegacao;

import andre.chamis.application.command.application.menu.MenuCommand;

public class ReturnCommand extends MenuCommand {
    @Override
    public void execute() {
        super.getMenu().goBack();
    }
}
