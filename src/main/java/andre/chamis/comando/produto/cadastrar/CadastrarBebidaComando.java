package andre.chamis.comando.produto.cadastrar;

import andre.chamis.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.Bebida;

public class CadastrarBebidaComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Iniciando o input de uma nova bebida\n");

        super.getProdutoService().cadastrar(Bebida.fromInput());
    }
}
