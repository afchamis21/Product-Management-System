package andre.chamis.domain.produto;

import andre.chamis.domain.fabricante.Fabricante;
import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

public class ProdutoAlimenticio extends Produto{
    protected Date validade;
    protected String[] ingredientes;

    public ProdutoAlimenticio(String nome, BigDecimal preco, String descricao, Fabricante fabricante, Date validade, String[] ingredientes, Integer estoque) {
        super(nome, preco, descricao, fabricante, estoque);
        this.validade = validade;
        this.ingredientes = ingredientes;
    }

    public ProdutoAlimenticio(){
        super();
    }

    public Date getValidade() {
        return validade;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public void imprimir(int padding) {
        super.imprimir(padding);
        System.out.println(StringUtils.adicionarPadding("- Validade: " + validade, padding));
        System.out.println(StringUtils.adicionarPadding("- Ingredientes: ", padding));
        for (String ingrediente: ingredientes) {
            System.out.println(StringUtils.adicionarPadding("- " + ingrediente, padding + 2));
        }
    }

    @Override
    protected void input() {
        super.input();
        this.validade = InputUtils.getDateInput("Digite a data de validade do produto: ");
        this.ingredientes = InputUtils.getStringArrayInput("Digite os ingredientes: ");
    }

    public static ProdutoAlimenticio fromInput() {
        System.out.println("\nIniciando o input de um novo produto alimentício\n");

        ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio();
        produtoAlimenticio.input();
        return produtoAlimenticio;
    }
}
