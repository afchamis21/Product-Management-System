package andre.chamis.services;

import andre.chamis.domain.product.Product;
import andre.chamis.repo.ProductRepository;

import java.util.List;

public class ProductService {
    private static ProductService instance;

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }

        return instance;
    }

    private ProductService() {
    }

    private final ProductRepository repo = new ProductRepository();

    public void register(Product product) {
        repo.salvar(product);
    }

    public List<Product> getAll() {
        return repo.getAll();
    }

    public <T extends Product> List<T> getAllByClass(Class<T> tClass) {
        return repo.getAllByClass(tClass);
    }

    public <T extends Product> void printAllByType(Class<T> tClass) {
        List<T> products = getAllByClass(tClass);
        for (int i = 0; i < products.size(); i++) {
            T product = products.get(i);
            product.print();

            if (i != products.size() - 1) {
                System.out.println();
            }
        }
    }

    public void printAll() {
        List<Product> products = getAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            product.print();

            if (i != products.size() - 1) {
                System.out.println();
            }
        }
    }
}
