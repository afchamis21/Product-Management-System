package andre.chamis.domain.produto;

import andre.chamis.domain.fabricante.Fabricante;
import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

import java.math.BigDecimal;

public class ProdutoEletronico extends Produto{
    private String modelo;

    public ProdutoEletronico(String nome, BigDecimal preco, String descricao, Fabricante fabricante, String modelo, Integer estoque) {
        super(nome, preco, descricao, fabricante, estoque);
        this.modelo = modelo;
    }

    public ProdutoEletronico(){
        super();
    }

    public String getModelo() {
        return modelo;
    }


    @Override
    public void imprimir(int padding) {
        super.imprimir(padding);
        System.out.println(StringUtils.adicionarPadding("- Modelo: " + modelo, padding));
    }

    @Override
    protected void input() {
        super.input();
        this.modelo = InputUtils.getStringInput("Digite o modelo do produto: ");
    }

    public static ProdutoEletronico fromInput() {
        System.out.println("\nIniciando o input de um novo produto eletrônico\n");

        ProdutoEletronico produtoEletronico = new ProdutoEletronico();
        produtoEletronico.input();
        return produtoEletronico;
    }
}
