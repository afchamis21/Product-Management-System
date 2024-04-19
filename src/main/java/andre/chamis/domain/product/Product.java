package andre.chamis.domain.product;

import andre.chamis.domain.manufacturer.Manufacturer;
import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Product {
    protected UUID uuid;
    protected String name;
    protected BigDecimal price;
    protected String description;
    protected Manufacturer manufacturer;
    protected Integer stock;


    public Product(String name, BigDecimal price, String description, Manufacturer manufacturer, Integer stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.uuid = UUID.randomUUID();
        this.stock = stock;
    }

    public Product() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void print() {
        print(4);
    }

    public void print(int padding) {
        System.out.println(StringUtils.addPadding("- ID: " + uuid, padding));
        System.out.println(StringUtils.addPadding("- Nome: " + name, padding));
        System.out.println(StringUtils.addPadding("- Descrição: " + description, padding));
        System.out.println(StringUtils.addPadding("- Preço: R$ " + price, padding));
        System.out.println(StringUtils.addPadding("- Estoque: " + stock + " unidades", padding));
        System.out.println(StringUtils.addPadding("- Fabricante: ", padding));
        manufacturer.imprimir(padding + 2);
    }

    public static Product fromInput() {
        return new Product() {
        };
    }

    protected void input() {
        this.name = InputUtils.getStringInput("Digite o nome do produto: ");
        this.description = InputUtils.getStringInput("Digite a descrição do produto: ");
        this.price = InputUtils.getBigDecimalInput("Digite o preço do produto (apenas número): ");
        this.stock = InputUtils.getIntegerInput("Digite o estoque do produto: ");
        this.manufacturer = Manufacturer.fromInputs();
        this.uuid = UUID.randomUUID();
    }
}
