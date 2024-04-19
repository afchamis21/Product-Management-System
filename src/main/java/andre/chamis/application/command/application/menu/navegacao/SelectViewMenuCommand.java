package andre.chamis.application.command.application.menu.navegacao;

import andre.chamis.application.command.application.menu.MenuCommand;
import andre.chamis.application.menu.MenuType;

public class SelectViewMenuCommand extends MenuCommand {
    @Override
    public void execute() {
        super.getMenu().changeMenu(MenuType.VIEW);
    }
}
