package andre.chamis.domain.product;

import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

public class ElectronicProduct extends Product {
    private String model;

    public ElectronicProduct(){
        super();
    }


    @Override
    public void print(int padding) {
        super.print(padding);
        System.out.println(StringUtils.addPadding("- Modelo: " + model, padding));
    }

    @Override
    protected void input() {
        super.input();
        this.model = InputUtils.getStringInput("Digite o modelo do produto: ");
    }

    public static ElectronicProduct fromInput() {
        ElectronicProduct electronicProduct = new ElectronicProduct();
        electronicProduct.input();
        return electronicProduct;
    }
}
