package andre.chamis.application.command.product.visualizar;

import andre.chamis.application.command.product.ProductCommand;
import andre.chamis.domain.product.Drink;

public class ViewDrinksCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Bebidas Cadastradas:\n");

        super.getProductService().printAllByType(Drink.class);
    }
}
