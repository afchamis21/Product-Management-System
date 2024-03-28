package andre.chamis.application.comando.aplicacao;

import andre.chamis.application.comando.Comando;

public class SairComando implements Comando {
    @Override
    public void executar() {
        System.out.println("Parando o programa");
        System.exit(0);
    }
}
