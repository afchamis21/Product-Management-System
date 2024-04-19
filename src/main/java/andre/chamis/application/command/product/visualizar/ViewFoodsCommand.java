package andre.chamis.application.command.product.visualizar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.Food;

public class ViewFoodsCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Produtos Alimentícios Cadastrados:\n");

        super.getProductService().printAllByType(Food.class);
    }
}
