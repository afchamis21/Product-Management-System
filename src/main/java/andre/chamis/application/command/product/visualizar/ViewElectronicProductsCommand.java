package andre.chamis.application.command.product.visualizar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.ElectronicProduct;

public class ViewElectronicProductsCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Produtos Eletrônicos Cadastrados:\n");

        super.getProductService().printAllByType(ElectronicProduct.class);
    }
}