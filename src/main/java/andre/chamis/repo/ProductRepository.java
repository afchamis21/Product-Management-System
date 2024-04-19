package andre.chamis.repo;

import andre.chamis.domain.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductRepository {
    private final Map<UUID, Product> products;

    public ProductRepository(){
        this.products = new HashMap<>();
    }

    public void salvar(Product product) {
        products.put(product.getUuid(), product);
    }

    public List<Product> getAll() {
        return products.values().stream().toList();
    }

    public <T extends Product> List<T> getAllByClass(Class<T> tClass) {
        return products.values().stream()
                .filter(tClass::isInstance)
                .map(tClass::cast)
                .toList();
    }
}
