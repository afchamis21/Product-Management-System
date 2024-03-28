package andre.chamis.application.menu;

import andre.chamis.domain.exception.EnumMappingException;
import andre.chamis.utils.InputUtils;

import java.util.List;

public class Menu {
    private static Menu instancia;
    private TipoMenu menuAtivo = TipoMenu.PRINCIPAL;
    private List<OpcaoMenu> opcoesDoMenu;

    private Menu() {
    }

    public static Menu getInstancia() {
        if (instancia == null){
            instancia = new Menu();
        }

        return instancia;
    }

    public void executarMenu() {
        definirMenu();

        while (true) {
            imprimirMenu();
            OpcaoMenu opcaoMenu = pegarOpcao();
            opcaoMenu.getComando().executar();
        }
    }

    private OpcaoMenu pegarOpcao() {
        try {
            Integer input = InputUtils.getIntegerInput("Escolha uma opção: ");

            if (null == input) {
                System.out.println("Escolha uma opção válida!");
                return pegarOpcao();
            }

            System.out.println();

            return OpcaoMenu.pegarPorValorETipo(input, this.menuAtivo);
        } catch (EnumMappingException e) {
            System.out.println(e.getMessage());
            return pegarOpcao();
        }
    }

    private void imprimirMenu() {
        System.out.println("\n" + this.menuAtivo.getMensagem());
        for (OpcaoMenu opcaoMenu : this.opcoesDoMenu) {
            System.out.println(opcaoMenu.getValor() + " - " + opcaoMenu.getMensagem());
        }
        System.out.println();
    }

    public void definirMenu() {
        this.opcoesDoMenu = OpcaoMenu.pegarPorTipo(this.menuAtivo);
    }

    public void voltar() {
        if (this.menuAtivo.getAnterior().isEmpty()) {
            System.out.println("Não é possível retornar desse menu!");
            return;
        }

        mudarMenu(this.menuAtivo.getAnterior().get());
    }

    public void mudarMenu(TipoMenu novoTipo) {
        if (novoTipo.equals(TipoMenu.GERAL)) {
            throw new RuntimeException("O tipo de menu Geral nunca deve ser ativado!");
        }

        this.menuAtivo = novoTipo;
        definirMenu();
    }
}
