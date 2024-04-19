package andre.chamis.application.menu;

import andre.chamis.application.command.Command;
import andre.chamis.application.command.application.QuitCommand;
import andre.chamis.application.command.application.menu.navegacao.ReturnCommand;
import andre.chamis.application.command.application.menu.navegacao.SelectRegisterMenuCommand;
import andre.chamis.application.command.application.menu.navegacao.SelectViewMenuCommand;
import andre.chamis.application.command.product.cadastrar.RegisterClothingProductCommand;
import andre.chamis.application.command.product.cadastrar.RegisterDrinkCommand;
import andre.chamis.application.command.product.cadastrar.RegisterElectronicProductCommand;
import andre.chamis.application.command.product.cadastrar.RegisterFoodCommand;
import andre.chamis.application.command.product.visualizar.*;
import andre.chamis.domain.exception.EnumMappingException;

import java.util.Arrays;
import java.util.List;

public enum MenuOption {
    // Items gerais do menu
    QUIT(MenuType.GENERAL,0, "Sair da aplicação", new QuitCommand()),
    BACK(MenuType.GENERAL, 1, "Voltar", new ReturnCommand()),


    // Items do menu principal
    REGISTER_PRODUCT(MenuType.MAIN, 2, "Cadastrar novo Produto", new SelectRegisterMenuCommand()),
    VIEW_PRODUCT(MenuType.MAIN, 3, "Visualizar Produtos", new SelectViewMenuCommand()),


    // Items do menu de cadastrar
    REGISTER_DRINK(MenuType.REGISTER, 2, "Bebida", new RegisterDrinkCommand()),
    REGISTER_FOOD(MenuType.REGISTER, 3, "Produto alimentício", new RegisterFoodCommand()),
    REGISTER_ELECTRONIC_PRODUCT(MenuType.REGISTER, 4, "Produto eletrônico", new RegisterElectronicProductCommand()),
    REGISTER_CLOTHING_PRODUCT(MenuType.REGISTER, 5, "Produto de vestuário", new RegisterClothingProductCommand()),


    // Items do menu de visualizar
    VIEW_DRINKS(MenuType.VIEW, 2, "Bebidas", new ViewDrinksCommand()),
    VIEW_FOODS(MenuType.VIEW, 3, "Produtos alimentícios", new ViewFoodsCommand()),
    VIEW_ELECTRONIC_PRODUCTS(MenuType.VIEW,4, "Produtos eletrônicos", new ViewElectronicProductsCommand()),
    VIEW_CLOTHING_PRODUCTS(MenuType.VIEW, 5, "Produtos de vestuário", new ViewClothingProductsCommand()),
    VIEW_ALL_PRODUCTS(MenuType.VIEW, 6, "Todos os produtos", new ViewAllProductsCommand());

    private final MenuType menuType;
    private final String message;
    private final Integer value;
    private final Command command;


    public String getMessage() {
        return message;
    }

    public Integer getValue() {
        return value;
    }

    public Command getCommand() {
        return command;
    }

    MenuOption(MenuType menuType, Integer value, String message, Command command) {
        this.menuType = menuType;
        this.value = value;
        this.message = message;
        this.command = command;
    }

    public static MenuOption getByValueAndType(Integer value, MenuType menuType) throws EnumMappingException {
        if (value == null) {
            throw new EnumMappingException("Valor não pode ser null!");
        }
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.value.equals(value) && (menuOption.menuType.equals(menuType) || menuOption.menuType.equals(MenuType.GENERAL))) {
                return menuOption;
            }
        }

        throw new EnumMappingException("Opção inválida: " + value);
    }

    public static List<MenuOption> getAllByType(MenuType menuType) {
        return Arrays.stream(MenuOption.values()).filter(menuOption -> menuOption.menuType.equals(menuType) || menuOption.menuType.equals(MenuType.GENERAL)).toList();
    }
}
