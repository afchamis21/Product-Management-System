package andre.chamis.application.comando.produto.cadastrar;

import andre.chamis.application.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.ProdutoAlimenticio;

public class CadastrarProdutoAlimenticioComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Iniciando o input de um novo produto alimentício\n");

        super.getProdutoService().cadastrar(ProdutoAlimenticio.fromInput());
    }
}
