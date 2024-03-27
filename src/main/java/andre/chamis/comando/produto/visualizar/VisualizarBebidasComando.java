package andre.chamis.comando.produto.visualizar;

import andre.chamis.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.Bebida;

public class VisualizarBebidasComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Bebidas Cadastradas:\n");

        super.getProdutoService().imprimirTodosPorTipo(Bebida.class);
    }
}
