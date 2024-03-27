package andre.chamis.comando.produto;

import andre.chamis.comando.Comando;
import andre.chamis.services.ProdutoService;

public abstract class ProdutoComando implements Comando {
    private final ProdutoService produtoService;

    public ProdutoComando() {
        produtoService = ProdutoService.getInstance();
    }

    protected ProdutoService getProdutoService() {
        return produtoService;
    }
}
