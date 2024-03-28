package andre.chamis.application.comando.aplicacao.menu.navegacao;

import andre.chamis.application.comando.aplicacao.menu.MenuComando;
import andre.chamis.application.menu.TipoMenu;

public class SelecionarMenuVisualizarComando extends MenuComando {
    @Override
    public void executar() {
        super.getMenu().mudarMenu(TipoMenu.VISUALIZAR);
    }
}
