package andre.chamis.comando.produto.visualizar;

import andre.chamis.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.ProdutoVestuario;

public class VisualizarProdutosVestuariosComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Produtos de Vestuário Cadastrados:\n");

        super.getProdutoService().imprimirTodosPorTipo(ProdutoVestuario.class);
    }
}
