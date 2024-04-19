package andre.chamis.application.command.product;

import andre.chamis.application.command.Command;
import andre.chamis.services.ProductService;

public abstract class ProductCommand implements Command {
    private final ProductService productService;

    public ProductCommand() {
        productService = ProductService.getInstance();
    }

    protected ProductService getProductService() {
        return productService;
    }
}
