package andre.chamis.application.command.application.menu;

import andre.chamis.application.command.Command;
import andre.chamis.application.menu.Menu;

public abstract class MenuCommand implements Command {
    private final Menu menu;

    public MenuCommand() {
        menu = Menu.getInstance();
    }

    protected Menu getMenu() {
        return menu;
    }
}
