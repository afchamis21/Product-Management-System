package andre.chamis.domain.produto;

import andre.chamis.domain.exception.EnumMappingException;
import andre.chamis.domain.fabricante.Fabricante;
import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

import java.math.BigDecimal;

public class ProdutoVestuario extends Produto{
    private Tamanho tamanho;
    private String cor;
    private String material;
    public ProdutoVestuario(String nome, BigDecimal preco, String descricao, Fabricante fabricante, Tamanho tamanho, String cor, String material, Integer estoque) {
        super(nome, preco, descricao, fabricante, estoque);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    public ProdutoVestuario() {
        super();
    }

    @Override
    public void imprimir(int padding) {
        super.imprimir(padding);
        System.out.println(StringUtils.adicionarPadding("- Tamanho: " + tamanho, padding));
        System.out.println(StringUtils.adicionarPadding("- Cor: " + cor, padding));
        System.out.println(StringUtils.adicionarPadding("- Material: " + material, padding));
    }

    @Override
    protected void input() {
        super.input();
        this.cor = InputUtils.getStringInput("Digite a cor do produto: ");
        this.material = InputUtils.getStringInput("Digite o material do produto: ");

        while (true) {
            try {
                this.tamanho = Tamanho.fromString(InputUtils.getStringInput(
                        "Digite o tamanho do produto (PP, P, M, G, XG, XXG): ")
                );
                break;
            } catch (EnumMappingException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Por favor, digite uma das unidades suportadas!");
            }
        }
    }

    public static ProdutoVestuario fromInput() {
        ProdutoVestuario produtoVestuario = new ProdutoVestuario();
        produtoVestuario.input();
        return produtoVestuario;
    }

    public enum Tamanho {
        PP, P, M, G, XG, XXG;

        public static Tamanho fromString(String string) throws EnumMappingException {
            if (string == null) {
                throw new EnumMappingException("String não pode ser null!");
            }

            for (Tamanho tamanho : Tamanho.values()) {
                if (tamanho.name().equalsIgnoreCase(string)) {
                    return tamanho;
                }
            }

            throw new EnumMappingException("Tamanho " + string + " não suportado!");
        }
    }
}
