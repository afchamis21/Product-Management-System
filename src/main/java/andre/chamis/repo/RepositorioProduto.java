package andre.chamis.repo;

import andre.chamis.domain.produto.Produto;

import java.util.*;

public class RepositorioProduto<T extends Produto> {
    private final Map<UUID, T> produtos;

    public RepositorioProduto(){
        this.produtos = new HashMap<>();
    }

    public void salvar(T produto) {
        produtos.put(produto.getUuid(), produto);
    }

    public T pegarPorId(UUID uuid) {
        return produtos.get(uuid);
    }

    public Collection<T> pegarTodos() {
        return produtos.values();
    }
}
