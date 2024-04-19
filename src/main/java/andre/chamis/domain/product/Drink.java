package andre.chamis.domain.product;

import andre.chamis.domain.exception.EnumMappingException;
import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

import java.math.BigDecimal;

public class Drink extends Food {
    private Boolean isAlcoholic;
    private BigDecimal volume;
    private UnitOfMeasurement unitOfMeasurement;

    public Drink(){
        super();
    }

    @Override
    public void print(int padding) {
        super.print(padding);
        System.out.println(StringUtils.addPadding("- Alcoólico: " + isAlcoholic, padding));
        System.out.println(StringUtils.addPadding("- Volume: " + volume + " " + unitOfMeasurement, padding));
    }

    @Override
    protected void input() {
        super.input();

        String bolInput;
        while (true) {
            bolInput = InputUtils.getStringInput("O produto é alcoólico? (Y/n) ");
            if ("Y".equalsIgnoreCase(bolInput) || "N".equalsIgnoreCase(bolInput)) {
                this.isAlcoholic = "Y".equalsIgnoreCase(bolInput);
                break;
            }
            System.out.println("Digite Y ou N");
        }

        this.volume = InputUtils.getBigDecimalInput("Digite o volume do produto (valor numérico): ");

        while (true) {
            try {
                this.unitOfMeasurement = UnitOfMeasurement.fromString(InputUtils.getStringInput(
                        "Digite a unidade de volume do produto (ML, L): ")
                );
                break;
            } catch (EnumMappingException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Por favor, digite uma das unidades suportadas!");
            }
        }
    }

    public static Drink fromInput() {
        Drink drink = new Drink();
        drink.input();
        return drink;
    }

    public enum UnitOfMeasurement {
        ML, L;

        public static UnitOfMeasurement fromString(String string) throws EnumMappingException {
            if (string == null) {
                throw new EnumMappingException("String não pode ser null!");
            }

            for (UnitOfMeasurement unit : UnitOfMeasurement.values()) {
                if (unit.name().equalsIgnoreCase(string)) {
                    return unit;
                }
            }

            throw new EnumMappingException("Unidade " + string + " não suportada!");
        }
    }
}
