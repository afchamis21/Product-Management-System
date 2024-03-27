package andre.chamis.comando.produto.visualizar;

import andre.chamis.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.ProdutoEletronico;

public class VisualizarProdutosEletronicosComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Produtos Eletrônicos Cadastrados:\n");

        super.getProdutoService().imprimirTodosPorTipo(ProdutoEletronico.class);
    }
}
