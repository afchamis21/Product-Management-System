package andre.chamis.domain.fabricante;

import andre.chamis.utils.InputUtils;
import andre.chamis.utils.StringUtils;

public class Fabricante {
    private String nome;
    private String endereco;
    private String telefone;

    public Fabricante(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    private Fabricante() {}

    public void imprimir(int padding) {
        System.out.println(StringUtils.adicionarPadding("- Nome: " + nome, padding));
        System.out.println(StringUtils.adicionarPadding("- Endereço: " + endereco, padding));
        System.out.println(StringUtils.adicionarPadding("- Telefone: " + telefone, padding));
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public static Fabricante fromInputs(){
        Fabricante fabricante = new Fabricante();
        fabricante.nome = InputUtils.getStringInput("Digite o nome do fabricante: ");
        fabricante.endereco = InputUtils.getStringInput("Digite o endereço do fabricante: ");
        fabricante.telefone = InputUtils.getStringInput("Digite o telefone do fabricante: ");
        return fabricante;
    }
}
