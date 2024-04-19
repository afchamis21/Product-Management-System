package andre.chamis.domain.manufacturer;

import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

public class Manufacturer {
    private String name;
    private String address;
    private String phone;

    private Manufacturer() {}

    public void imprimir(int padding) {
        System.out.println(StringUtils.addPadding("- Nome: " + name, padding));
        System.out.println(StringUtils.addPadding("- Endereço: " + address, padding));
        System.out.println(StringUtils.addPadding("- Telefone: " + phone, padding));
    }

    public static Manufacturer fromInputs(){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.name = InputUtils.getStringInput("Digite o nome do fabricante: ");
        manufacturer.address = InputUtils.getStringInput("Digite o endereço do fabricante: ");
        manufacturer.phone = InputUtils.getStringInput("Digite o telefone do fabricante: ");
        return manufacturer;
    }
}
