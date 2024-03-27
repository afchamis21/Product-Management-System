package andre.chamis.services;

import andre.chamis.domain.produto.Produto;
import andre.chamis.repo.RepositorioProduto;

import java.util.List;

public class ProdutoService {
    private static ProdutoService instancia;

    public static ProdutoService getInstance() {
        if (instancia == null) {
            instancia = new ProdutoService();
        }

        return instancia;
    }

    private ProdutoService() {
    }

    private final RepositorioProduto repo = new RepositorioProduto();

    public void cadastrar(Produto produto) {
        repo.salvar(produto);
    }

    public List<Produto> pegarTodos() {
        return repo.pegarTodos();
    }

    public <T extends Produto> List<T> pegarTodosDoTipo(Class<T> tClass) {
        return repo.pegarPorTipo(tClass);
    }

    public <T extends Produto> void imprimirTodosPorTipo(Class<T> tClass) {
        List<T> produtos = pegarTodosDoTipo(tClass);
        for (int i = 0; i < produtos.size(); i++) {
            T produto = produtos.get(i);
            produto.imprimir();

            if (i != produtos.size() - 1) {
                System.out.println();
            }
        }
    }

    public void imprimirTodos() {
        List<Produto> produtos = pegarTodos();
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            produto.imprimir();

            if (i != produtos.size() - 1) {
                System.out.println();
            }
        }
    }
}
