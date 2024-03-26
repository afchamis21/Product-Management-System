package andre.chamis.domain.produto;

import andre.chamis.domain.fabricante.Fabricante;
import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

public class Bebida extends ProdutoAlimenticio {
    private Boolean ehAlcoolico;
    private BigDecimal volume;
    private UnidadeDeVolume unidadeDeVolume;

    public Bebida(String nome, BigDecimal preco, String descricao, Fabricante fabricante, Date validade, String[] ingredientes, Boolean ehAlcoolico, BigDecimal volume, UnidadeDeVolume unidadeDeVolume, Integer estoque) {
        super(nome, preco, descricao, fabricante, validade, ingredientes, estoque);
        this.ehAlcoolico = ehAlcoolico;
        this.volume = volume;
        this.unidadeDeVolume = unidadeDeVolume;
    }

    public Bebida(){
        super();
    }

    public Boolean getEhAlcoolico() {
        return ehAlcoolico;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public UnidadeDeVolume getUnidadeDeVolume() {
        return unidadeDeVolume;
    }

    @Override
    public void imprimir(int padding) {
        super.imprimir(padding);
        System.out.println(StringUtils.adicionarPadding("- Alcoólico: " + ehAlcoolico, padding));
        System.out.println(StringUtils.adicionarPadding("- Volume: " + volume + " " + unidadeDeVolume, padding));
    }

    @Override
    protected void input() {
        super.input();

        String bolInput;
        while (true) {
            bolInput = InputUtils.getStringInput("O produto é alcoólico? (Y/n) ");
            if ("Y".equalsIgnoreCase(bolInput) || "N".equalsIgnoreCase(bolInput)) {
                this.ehAlcoolico = "Y".equalsIgnoreCase(bolInput);
                break;
            }
            System.out.println("Digite Y ou N");
        }

        this.volume = InputUtils.getBigDecimalInput("Digite o volume do produto (valor numérico): ");

        while (true) {
            try {
                this.unidadeDeVolume = UnidadeDeVolume.fromString(InputUtils.getStringInput(
                        "Digite a unidade de volume do produto (ML, L): ")
                );
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Por favor, digite uma das unidades suportadas!");
            }
        }
    }

    public static Bebida fromInput() {
        System.out.println("\nIniciando o input de uma nova bebida\n");

        Bebida bebida = new Bebida();
        bebida.input();
        return bebida;
    }

    public enum UnidadeDeVolume {
        ML, L;

        static UnidadeDeVolume fromString(String string) throws Exception {
            if (string == null) {
                throw new Exception("String não pode ser null!");
            }

            if ("ML".equalsIgnoreCase(string)) {
                return ML;
            }

            if ("L".equalsIgnoreCase(string)) {
                return L;
            }

            throw new Exception("Unidade " + string + " não suportada!");
        }
    }
}
