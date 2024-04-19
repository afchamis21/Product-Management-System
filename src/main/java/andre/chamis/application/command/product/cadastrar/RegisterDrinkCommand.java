package andre.chamis.application.command.product.cadastrar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.Drink;

public class RegisterDrinkCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Iniciando o input de uma nova bebida\n");

        super.getProductService().register(Drink.fromInput());
    }
}
