package andre.chamis.application.comando.aplicacao.menu.navegacao;

import andre.chamis.application.comando.aplicacao.menu.MenuComando;

public class VoltarComando extends MenuComando {
    @Override
    public void executar() {
        super.getMenu().voltar();
    }
}
