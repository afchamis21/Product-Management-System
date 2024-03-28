package andre.chamis.application.menu;

import java.util.Optional;

public enum TipoMenu {
    GERAL("", null),
    PRINCIPAL("O que deseja fazer?", null),
    CADASTRAR("Qual tipo de produto deseja cadastrar?", TipoMenu.PRINCIPAL),
    VISUALIZAR("Quais produtos deseja visualizar?", TipoMenu.PRINCIPAL);

    private final String mensagem;
    private final TipoMenu anterior;

    TipoMenu(String mensagem, TipoMenu anterior) {
        this.mensagem = mensagem;
        this.anterior = anterior;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Optional<TipoMenu> getAnterior() {
        return Optional.ofNullable(anterior);
    }
}
