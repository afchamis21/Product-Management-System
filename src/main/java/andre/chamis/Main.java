package andre.chamis;

import andre.chamis.domain.fabricante.Fabricante;
import andre.chamis.domain.produto.*;
import andre.chamis.repo.RepositorioProduto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;

public class Main {
    private static final RepositorioProduto<ProdutoEletronico> repositorioProdutoEletronicos = new RepositorioProduto<>();
    private static final RepositorioProduto<ProdutoVestuario> repositorioProdutoVestuarios = new RepositorioProduto<>();
    private static final RepositorioProduto<ProdutoAlimenticio> repositorioProdutoAlimenticios = new RepositorioProduto<>();
    private static final RepositorioProduto<Bebida> repositorioBebidas = new RepositorioProduto<>();
    public static void main(String[] args) {
        cadastrarProdutoEletronico(new ProdutoEletronico(
                "Celular Galaxy S22",
                new BigDecimal("2499.99"),
                "Um celular muito bom",
                gerarFabricante("Samsung"),
                "Galaxy A22",
                1000

        ));

        cadastrarProdutoVestuario(new ProdutoVestuario(
                "Camiseta de manga curta",
                new BigDecimal("99.99"),
                "Camiseta confortável da Calvin Klein",
                gerarFabricante("Calvin Klein"),
                ProdutoVestuario.Tamanho.M,
                "Branca",
                "Algodão",
                1000
        ));

        cadastrarProdutoAlimenticio(new ProdutoAlimenticio(
                "Picanha",
                new BigDecimal("99.99"),
                "Picanha refrigerada linha premium",
                gerarFabricante("Friboi"),
                Date.from(Instant.now().plus(24L, ChronoUnit.HOURS)),
                new String[]{"Carne de boi", "Conservantes"},
                50
        ));

        cadastrarBebida(new Bebida(
                "Cerveja Brahma Duplo Malte",
                new BigDecimal("4.99"),
                "Cerveja Duplo Malte Latão",
                gerarFabricante("Brahma"),
                Date.from(Instant.now().plus(30 * 6, ChronoUnit.DAYS)),
                new String[]{"Cevada", "Gás", "Lúpulo", "Álcool"},
                true,
                new BigDecimal("473.00"),
                Bebida.UnidadeDeVolume.ML,
                100
        ));

//         Fiz também, para praticar mais, alguns métodos para cadastro dos produtos por inputs caso você queira
//         testar professor ;)
        cadastrarProdutoEletronico(ProdutoEletronico.fromInput());
        cadastrarProdutoVestuario(ProdutoVestuario.fromInput());
        cadastrarProdutoAlimenticio(ProdutoAlimenticio.fromInput());
        cadastrarBebida(Bebida.fromInput());

        exibirTodosOsProdutos();
    }

    private static Fabricante gerarFabricante(String nome) {
        return new Fabricante(nome, "Avenida " + nome + ", 123", "(11) 9 1234-5678");
    }

    private static void cadastrarProdutoEletronico(ProdutoEletronico produto) {
        repositorioProdutoEletronicos.salvar(produto);
    }

    private static void cadastrarProdutoVestuario(ProdutoVestuario produto) {
        repositorioProdutoVestuarios.salvar(produto);
    }

    private static void cadastrarProdutoAlimenticio(ProdutoAlimenticio produto) {
        repositorioProdutoAlimenticios.salvar(produto);
    }

    private static void cadastrarBebida(Bebida produto) {
        repositorioBebidas.salvar(produto);
    }

    private static void exibirTodosOsProdutos(){
        System.out.println("\nExibindo todos os produtos:");
        verProdutosEletronicos();
        verProdutoVestuario();
        verProdutoAlimenticio();
        verProdutosBebida();
    }

    private static void verProdutosEletronicos(){
        System.out.println("\nProdutos Eletrônicos Cadastrados:");
        visualizarCadastrados(repositorioProdutoEletronicos);
    }
    private static void verProdutoVestuario(){
        System.out.println("\nProdutos de Vestuário Cadastrados:");
        visualizarCadastrados(repositorioProdutoVestuarios);
    }
    private static void verProdutoAlimenticio(){
        System.out.println("\nProdutos Alimentícios Cadastrados:");
        visualizarCadastrados(repositorioProdutoAlimenticios);
    }
    private static void verProdutosBebida(){
        System.out.println("\nBebidas Cadastradas:");
        visualizarCadastrados(repositorioBebidas);
    }

    private static <T extends Produto> void visualizarCadastrados(RepositorioProduto<T> repositorio) {
        Collection<T> produtos = repositorio.pegarTodos();

        for (Produto produto: produtos) {
            produto.imprimir();
        }
    }
}