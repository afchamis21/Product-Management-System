package andre.chamis.application.menu;

import andre.chamis.comando.Comando;
import andre.chamis.comando.aplicacao.SairComando;
import andre.chamis.comando.produto.cadastrar.CadastrarBebidaComando;
import andre.chamis.comando.produto.cadastrar.CadastrarProdutoAlimenticioComando;
import andre.chamis.comando.produto.cadastrar.CadastrarProdutoEletronicoComando;
import andre.chamis.comando.produto.cadastrar.CadastrarProdutoVestuarioComando;
import andre.chamis.comando.produto.visualizar.*;
import andre.chamis.domain.exception.EnumMappingException;

public enum Opcao {
    SAIR(0, "Sair da aplicação", new SairComando()),
    CADASTRAR_BEBIDA(1, "Cadastrar nova Bebida", new CadastrarBebidaComando()),
    CADASTRAR_PRODUTO_ALIMENTICIO(2, "Cadastrar novo Produto Alimentício", new CadastrarProdutoAlimenticioComando()),
    CADSATRAR_PRODUTO_ELETRONICO(3, "Cadastrar novo Produto Eletrônico", new CadastrarProdutoEletronicoComando()),
    CADASTRAR_PRODUTO_VESTUARIO(4, "Cadastrar novo Produto de Vestuário", new CadastrarProdutoVestuarioComando()),
    VISUALIZAR_BEBIDAS(5, "Visualizar Bebidas", new VisualizarBebidasComando()),
    VISUALIZAR_PRODUTOS_ALIMENTICIOS(6, "Visualizar Produtos Alimentícios", new VisualizarProdutosAlimenticiosComando()),
    VISUALIZAR_PRODUTOS_ELETRONICOS(7, "Visualizar Produtos Eletrônicos", new VisualizarProdutosEletronicosComando()),
    VISUALIZAR_PRODUTOS_VESTUARIO(8, "Visualizar Produtos de Vestuário", new VisualizarProdutosVestuariosComando()),
    VISUALIZAR_TODOS_PRODUTOS(9, "Visualizar todos os Produtos", new VisualizarTodosProdutosComando());

    private final String mensagem;
    private final Integer valor;
    private final Comando comando;

    public String getMensagem() {
        return mensagem;
    }

    public Integer getValor() {
        return valor;
    }

    public Comando getComando() {
        return comando;
    }

    Opcao(Integer valor, String mensagem, Comando comando) {
        this.valor = valor;
        this.mensagem = mensagem;
        this.comando = comando;
    }

    public static Opcao fromInteger(Integer valor) throws EnumMappingException {
        if (valor == null) {
            throw new EnumMappingException("Valor não pode ser null!");
        }
        for (Opcao opcao : Opcao.values()) {
            if (opcao.valor.equals(valor)) {
                return opcao;
            }
        }
        throw new EnumMappingException("Opção inválida: " + valor);
    }
}
