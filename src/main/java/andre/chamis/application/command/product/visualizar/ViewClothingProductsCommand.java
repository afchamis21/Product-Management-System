package andre.chamis.application.command.product.visualizar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.ClothingProduct;

public class ViewClothingProductsCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Produtos de Vestuário Cadastrados:\n");

        super.getProductService().printAllByType(ClothingProduct.class);
    }
}
