package andre.chamis.application.command.product.visualizar;

import andre.chamis.application.command.product.ProductCommand;

public class ViewAllProductsCommand extends ProductCommand {
    @Override
    public void execute() {
        System.out.println("Exibindo todos os produtos:\n");

        super.getProductService().printAll();
    }
}
