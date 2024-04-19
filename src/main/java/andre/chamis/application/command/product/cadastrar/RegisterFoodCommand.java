package andre.chamis.application.command.product.cadastrar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.Food;

public class RegisterFoodCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Iniciando o input de um novo produto alimentício\n");

        super.getProductService().register(Food.fromInput());
    }
}
