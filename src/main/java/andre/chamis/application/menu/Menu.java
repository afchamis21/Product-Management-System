package andre.chamis.application.menu;

import andre.chamis.domain.exception.EnumMappingException;
import andre.chamis.utils.InputUtils;

import java.util.List;

public class Menu {
    private static Menu instance;
    private MenuType activeMenu = MenuType.MAIN;
    private List<MenuOption> menuOptions;

    private Menu() {
    }

    public static Menu getInstance() {
        if (instance == null){
            instance = new Menu();
        }

        return instance;
    }

    public void execute() {
        getMenu();

        while (true) {
            printMenu();
            MenuOption menuOption = getOption();

            if (menuOption == MenuOption.QUIT) {
                menuOption.getCommand().execute();
                break;
            }

            menuOption.getCommand().execute();
        }
    }

    private MenuOption getOption() {
        try {
            Integer input = InputUtils.getIntegerInput("Escolha uma opção: ");

            if (null == input) {
                System.out.println("Escolha uma opção válida!");
                return getOption();
            }

            System.out.println();

            return MenuOption.getByValueAndType(input, this.activeMenu);
        } catch (EnumMappingException e) {
            System.out.println(e.getMessage());
            return getOption();
        }
    }

    private void printMenu() {
        System.out.println("\n" + this.activeMenu.getMessage());
        for (MenuOption menuOption : this.menuOptions) {
            System.out.println(menuOption.getValue() + " - " + menuOption.getMessage());
        }
        System.out.println();
    }

    public void getMenu() {
        this.menuOptions = MenuOption.getAllByType(this.activeMenu);
    }

    public void goBack() {
        if (this.activeMenu.getPrevious().isEmpty()) {
            System.out.println("Não é possível retornar desse menu!");
            return;
        }

        changeMenu(this.activeMenu.getPrevious().get());
    }

    public void changeMenu(MenuType novoTipo) {
        if (novoTipo.equals(MenuType.GENERAL)) {
            throw new RuntimeException("O tipo de menu Geral nunca deve ser ativado!");
        }

        this.activeMenu = novoTipo;
        getMenu();
    }
}
