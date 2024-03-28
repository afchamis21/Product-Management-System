package andre.chamis.application.comando.aplicacao.menu;

import andre.chamis.application.comando.Comando;
import andre.chamis.application.menu.Menu;

public abstract class MenuComando implements Comando {
    private final Menu menu;

    public MenuComando() {
        menu = Menu.getInstancia();
    }

    protected Menu getMenu() {
        return menu;
    }
}
