package andre.chamis.utils;

public class StringUtils {
    public static String adicionarPadding(String stringOriginal, int largura) {

        return " ".repeat(Math.max(0, largura)) +
                stringOriginal;
    }
}
