package andre.chamis.application.menu;

import java.util.Optional;

public enum MenuType {
    GENERAL("", null),
    MAIN("O que deseja fazer?", null),
    REGISTER("Qual tipo de produto deseja cadastrar?", MenuType.MAIN),
    VIEW("Quais produtos deseja visualizar?", MenuType.MAIN);

    private final String message;
    private final MenuType previous;

    MenuType(String message, MenuType previous) {
        this.message = message;
        this.previous = previous;
    }

    public String getMessage() {
        return message;
    }

    public Optional<MenuType> getPrevious() {
        return Optional.ofNullable(previous);
    }
}
