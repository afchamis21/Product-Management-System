package andre.chamis.repo;

import andre.chamis.domain.produto.Produto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RepositorioProduto {
    private final Map<UUID, Produto> produtos;

    public RepositorioProduto(){
        this.produtos = new HashMap<>();
    }

    public void salvar(Produto produto) {
        produtos.put(produto.getUuid(), produto);
    }

    public List<Produto> pegarTodos() {
        return produtos.values().stream().toList();
    }

    public <T extends Produto> List<T> pegarPorTipo(Class<T> tClass) {
        return produtos.values().stream()
                .filter(tClass::isInstance)
                .map(tClass::cast)
                .toList();
    }
}
