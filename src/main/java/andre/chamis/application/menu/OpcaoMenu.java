package andre.chamis.application.menu;

import andre.chamis.application.comando.Comando;
import andre.chamis.application.comando.aplicacao.SairComando;
import andre.chamis.application.comando.aplicacao.menu.navegacao.SelecionarMenuCadastrarComando;
import andre.chamis.application.comando.aplicacao.menu.navegacao.SelecionarMenuVisualizarComando;
import andre.chamis.application.comando.aplicacao.menu.navegacao.VoltarComando;
import andre.chamis.application.comando.produto.cadastrar.CadastrarBebidaComando;
import andre.chamis.application.comando.produto.cadastrar.CadastrarProdutoAlimenticioComando;
import andre.chamis.application.comando.produto.cadastrar.CadastrarProdutoEletronicoComando;
import andre.chamis.application.comando.produto.cadastrar.CadastrarProdutoVestuarioComando;
import andre.chamis.application.comando.produto.visualizar.*;
import andre.chamis.domain.exception.EnumMappingException;

import java.util.Arrays;
import java.util.List;

public enum OpcaoMenu {
    // Items gerais do menu
    SAIR(TipoMenu.GERAL,0, "Sair da aplicação", new SairComando()),
    VOLTAR(TipoMenu.GERAL, 1, "Voltar", new VoltarComando()),


    // Items do menu principal
    CADASTRAR_PRODUTO(TipoMenu.PRINCIPAL, 2, "Cadastrar novo Produto", new SelecionarMenuCadastrarComando()),
    VISUALIZAR_PRODUTO(TipoMenu.PRINCIPAL, 3, "Visualizar Produtos", new SelecionarMenuVisualizarComando()),


    // Items do menu de cadastrar
    CADASTRAR_BEBIDA(TipoMenu.CADASTRAR, 2, "Bebida", new CadastrarBebidaComando()),
    CADASTRAR_PRODUTO_ALIMENTICIO(TipoMenu.CADASTRAR, 3, "Produto alimentício", new CadastrarProdutoAlimenticioComando()),
    CADSATRAR_PRODUTO_ELETRONICO(TipoMenu.CADASTRAR, 4, "Produto eletrônico", new CadastrarProdutoEletronicoComando()),
    CADASTRAR_PRODUTO_VESTUARIO(TipoMenu.CADASTRAR, 5, "Produto de vestuário", new CadastrarProdutoVestuarioComando()),


    // Items do menu de visualizar
    VISUALIZAR_BEBIDAS(TipoMenu.VISUALIZAR, 2, "Bebidas", new VisualizarBebidasComando()),
    VISUALIZAR_PRODUTOS_ALIMENTICIOS(TipoMenu.VISUALIZAR, 3, "Produtos alimentícios", new VisualizarProdutosAlimenticiosComando()),
    VISUALIZAR_PRODUTOS_ELETRONICOS(TipoMenu.VISUALIZAR,4, "Produtos eletrônicos", new VisualizarProdutosEletronicosComando()),
    VISUALIZAR_PRODUTOS_VESTUARIO(TipoMenu.VISUALIZAR, 5, "Produtos de vestuário", new VisualizarProdutosVestuariosComando()),
    VISUALIZAR_TODOS_PRODUTOS(TipoMenu.VISUALIZAR, 6, "Todos os produtos", new VisualizarTodosProdutosComando());

    private final TipoMenu tipoMenu;
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

    OpcaoMenu(TipoMenu tipoMenu, Integer valor, String mensagem, Comando comando) {
        this.tipoMenu = tipoMenu;
        this.valor = valor;
        this.mensagem = mensagem;
        this.comando = comando;
    }

    public static OpcaoMenu pegarPorValorETipo(Integer valor, TipoMenu tipoMenu) throws EnumMappingException {
        if (valor == null) {
            throw new EnumMappingException("Valor não pode ser null!");
        }
        for (OpcaoMenu opcaoMenu : OpcaoMenu.values()) {
            if (opcaoMenu.valor.equals(valor) && (opcaoMenu.tipoMenu.equals(tipoMenu) || opcaoMenu.tipoMenu.equals(TipoMenu.GERAL))) {
                return opcaoMenu;
            }
        }
        throw new EnumMappingException("Opção inválida: " + valor);
    }

    public static List<OpcaoMenu> pegarPorTipo(TipoMenu tipoMenu) {
        return Arrays.stream(OpcaoMenu.values()).filter(opcaoMenu -> opcaoMenu.tipoMenu.equals(tipoMenu) || opcaoMenu.tipoMenu.equals(TipoMenu.GERAL)).toList();
    }
}
