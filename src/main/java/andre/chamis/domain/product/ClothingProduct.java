package andre.chamis.domain.product;

import andre.chamis.domain.exception.EnumMappingException;
import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

public class ClothingProduct extends Product {
    private Size size;
    private String color;
    private String material;

    public ClothingProduct() {
        super();
    }

    @Override
    public void print(int padding) {
        super.print(padding);
        System.out.println(StringUtils.addPadding("- Tamanho: " + size, padding));
        System.out.println(StringUtils.addPadding("- Cor: " + color, padding));
        System.out.println(StringUtils.addPadding("- Material: " + material, padding));
    }

    @Override
    protected void input() {
        super.input();
        this.color = InputUtils.getStringInput("Digite a cor do produto: ");
        this.material = InputUtils.getStringInput("Digite o material do produto: ");

        while (true) {
            try {
                this.size = Size.fromString(InputUtils.getStringInput(
                        "Digite o tamanho do produto (PP, P, M, G, XG, XXG): ")
                );
                break;
            } catch (EnumMappingException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Por favor, digite uma das unidades suportadas!");
            }
        }
    }

    public static ClothingProduct fromInput() {
        ClothingProduct clothingProduct = new ClothingProduct();
        clothingProduct.input();
        return clothingProduct;
    }

    public enum Size {
        PP, P, M, G, XG, XXG;

        public static Size fromString(String string) throws EnumMappingException {
            if (string == null) {
                throw new EnumMappingException("String não pode ser null!");
            }

            for (Size size : Size.values()) {
                if (size.name().equalsIgnoreCase(string)) {
                    return size;
                }
            }

            throw new EnumMappingException("Tamanho " + string + " não suportado!");
        }
    }
}
