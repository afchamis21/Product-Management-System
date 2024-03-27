package andre.chamis.comando.produto.visualizar;

import andre.chamis.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.ProdutoAlimenticio;

public class VisualizarProdutosAlimenticiosComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Produtos Alimentícios Cadastrados:\n");

        super.getProdutoService().imprimirTodosPorTipo(ProdutoAlimenticio.class);
    }
}
