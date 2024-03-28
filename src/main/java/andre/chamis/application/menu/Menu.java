package andre.chamis.application.menu;

import andre.chamis.domain.exception.EnumMappingException;
import andre.chamis.utils.InputUtils;

public class Menu {
    private static Menu instancia;

    private Menu() {
    }

    public static Menu getInstancia() {
        if (instancia == null){
            instancia = new Menu();
        }

        return instancia;
    }

    public void executarMenu() {
        while (true) {
            imprimirMenu();
            Opcao opcao = pegarOpcao();
            opcao.getComando().executar();
        }
    }

    private Opcao pegarOpcao() {
        try {
            Integer input = InputUtils.getIntegerInput("Escolha uma opção: ");

            if (null == input) {
                System.out.println("Escolha uma opção válida!");
                return pegarOpcao();
            }

            System.out.println();

            return Opcao.fromInteger(input);
        } catch (EnumMappingException e) {
            System.out.println(e.getMessage());
            return pegarOpcao();
        }
    }

    private void imprimirMenu() {
        System.out.println("\nO que você deseja fazer?\n");
        for (Opcao opcao : Opcao.values()) {
            System.out.println(opcao.getValor() + " - " + opcao.getMensagem());
        }
        System.out.println();
    }
}
