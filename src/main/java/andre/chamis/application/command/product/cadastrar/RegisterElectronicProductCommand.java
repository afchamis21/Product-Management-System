package andre.chamis.application.command.product.cadastrar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.ElectronicProduct;

public class RegisterElectronicProductCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Iniciando o input de um novo produto eletrônico\n");

        super.getProductService().register(ElectronicProduct.fromInput());
    }
}
