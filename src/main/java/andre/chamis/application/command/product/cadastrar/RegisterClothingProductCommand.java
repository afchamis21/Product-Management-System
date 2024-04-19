package andre.chamis.application.command.product.cadastrar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.ClothingProduct;

public class RegisterClothingProductCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Iniciando o input de um novo produto de vestuário\n");

        super.getProductService().register(ClothingProduct.fromInput());
    }
}
