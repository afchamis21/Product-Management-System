package andre.chamis.comando.produto.cadastrar;

import andre.chamis.comando.produto.ProdutoComando;
import andre.chamis.domain.produto.ProdutoVestuario;

public class CadastrarProdutoVestuarioComando extends ProdutoComando {
    @Override
    public void executar() {
        System.out.println("Iniciando o input de um novo produto de vestuário\n");

        super.getProdutoService().cadastrar(ProdutoVestuario.fromInput());
    }
}
