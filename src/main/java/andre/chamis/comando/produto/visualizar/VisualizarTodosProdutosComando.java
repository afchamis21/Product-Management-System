package andre.chamis.comando.produto.visualizar;

import andre.chamis.comando.produto.ProdutoComando;

public class VisualizarTodosProdutosComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Exibindo todos os produtos:\n");

        super.getProdutoService().imprimirTodos();
    }
}
