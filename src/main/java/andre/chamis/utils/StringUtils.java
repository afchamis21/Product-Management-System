package andre.chamis.utils;

public class StringUtils {
    public static String addPadding(String string, int size) {

        return " ".repeat(Math.max(0, size)) + string;
    }
}
