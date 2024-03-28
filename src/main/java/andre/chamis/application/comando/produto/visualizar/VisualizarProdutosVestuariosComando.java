package andre.chamis.application.comando.produto.visualizar;

import andre.chamis.application.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.ProdutoVestuario;

public class VisualizarProdutosVestuariosComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Produtos de Vestuário Cadastrados:\n");

        super.getProdutoService().imprimirTodosPorTipo(ProdutoVestuario.class);
    }
}
