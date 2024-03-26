package andre.chamis.utils;

public class StringUtils {
    public static String adicionarPadding(String stringOriginal, int largura) {
        StringBuilder sb = new StringBuilder();

        sb.append(" ".repeat(Math.max(0, largura)));
        sb.append(stringOriginal);
        return sb.toString();
    }
}
