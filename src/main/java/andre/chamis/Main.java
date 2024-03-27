package andre.chamis;

import andre.chamis.application.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = Menu.getInstancia();
        menu.initMenu();
    }
}