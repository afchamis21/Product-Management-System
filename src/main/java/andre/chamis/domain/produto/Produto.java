package andre.chamis.domain.produto;

import andre.chamis.domain.fabricante.Fabricante;
import andre.chamis.utils.StringUtils;
import andre.chamis.utils.InputUtils;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Produto {
    protected UUID uuid;
    protected String nome;
    protected BigDecimal preco;
    protected String descricao;
    protected Fabricante fabricante;
    protected Integer estoque;


    public Produto(String nome, BigDecimal preco, String descricao, Fabricante fabricante, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.uuid = UUID.randomUUID();
        this.estoque = estoque;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void imprimir() {
        imprimir(4);
    }

    public void imprimir(int padding) {
        System.out.println(StringUtils.adicionarPadding("- ID: " + uuid, padding));
        System.out.println(StringUtils.adicionarPadding("- Nome: " + nome, padding));
        System.out.println(StringUtils.adicionarPadding("- Descrição: " + descricao, padding));
        System.out.println(StringUtils.adicionarPadding("- Preço: R$ " + preco, padding));
        System.out.println(StringUtils.adicionarPadding("- Estoque: " + estoque + " unidades", padding));
        System.out.println(StringUtils.adicionarPadding("- Fabricante: ", padding));
        fabricante.imprimir(padding + 2);
    }

    public static Produto fromInput() {
        return new Produto() {
        };
    }

    protected void input() {
        this.nome = InputUtils.getStringInput("Digite o nome do produto: ");
        this.descricao = InputUtils.getStringInput("Digite a descrição do produto: ");
        this.preco = InputUtils.getBigDecimalInput("Digite o preço do produto (apenas número): ");
        this.estoque = InputUtils.getIntegerInput("Digite o estoque do produto: ");
        this.fabricante = Fabricante.fromInputs();
        this.uuid = UUID.randomUUID();
    }
}
