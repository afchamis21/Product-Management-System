package andre.chamis.application.comando.produto.cadastrar;

import andre.chamis.application.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.ProdutoEletronico;

public class CadastrarProdutoEletronicoComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Iniciando o input de um novo produto eletrônico\n");

        super.getProdutoService().cadastrar(ProdutoEletronico.fromInput());
    }
}
