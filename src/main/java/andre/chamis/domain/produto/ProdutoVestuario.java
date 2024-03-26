package andre.chamis.domain.produto;

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
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Por favor, digite uma das unidades suportadas!");
            }
        }
    }

    public static ProdutoVestuario fromInput() {
        System.out.println("\nIniciando o input de um novo produto de vestuário\n");

        ProdutoVestuario produtoVestuario = new ProdutoVestuario();
        produtoVestuario.input();
        return produtoVestuario;
    }

    public enum Tamanho {
        PP, P, M, G, XG, XXG;

        static Tamanho fromString(String string) throws Exception {
            if (string == null) {
                throw new Exception("String não pode ser null!");
            }

            if ("PP".equalsIgnoreCase(string)) {
                return PP;
            }

            if ("P".equalsIgnoreCase(string)) {
                return P;
            }

            if ("M".equalsIgnoreCase(string)) {
                return M;
            }

            if ("G".equalsIgnoreCase(string)) {
                return G;
            }

            if ("XG".equalsIgnoreCase(string)) {
                return XG;
            }

            if ("XXG".equalsIgnoreCase(string)) {
                return XXG;
            }

            throw new Exception("Tamanho " + string + " não suportado!");
        }
    }
}
