package andre.chamis.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private static void imprimirMensagem(String mensagem) {
        System.out.print(mensagem);
    }

    public static String getStringInput(String mensagem) {
        try {
            imprimirMensagem(mensagem);
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Insira um valor textual válido!");
            return getStringInput(mensagem);
        }
    }

    public static BigDecimal getBigDecimalInput(String mensagem) {
        try {
            imprimirMensagem(mensagem);
            BigDecimal valor = scanner.nextBigDecimal();
            scanner.nextLine();
            return valor;
        } catch (Exception e) {
            System.out.println("Insira um número decimal válido! Use (,) como separador decimal");
            scanner.nextLine();
            return getBigDecimalInput(mensagem);
        }
    }

    public static Integer getIntegerInput(String mensagem) {
        try {
            imprimirMensagem(mensagem);
            Integer valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (Exception e) {
            System.out.println("Insira um número válido!");
            scanner.nextLine();
            return getIntegerInput(mensagem);
        }
    }

    public static Date getDateInput(String mensagem) {
        SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");

        if (!mensagem.endsWith(" (MM/AAAA): ")) {
            mensagem = mensagem.replace(":", "") + " (MM/AAAA): ";
        }

        try {
            imprimirMensagem(mensagem);
            return df.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Insira uma data válida!");
            return getDateInput(mensagem);
        }
    }

    public static String[] getStringArrayInput(String mensagem) {
        List<String> strings = new ArrayList<>();

        String val;
        System.out.println(mensagem);
        System.out.println("Para parar o input, envie um input vazio, ou o número zero (0)");
        do {
            val = getStringInput(" - ");
            if (!val.isBlank() && !"0".equals(val)) {
                strings.add(val);
            }
        } while (!(val.isBlank() || "0".equals(val)));

        return strings.toArray(String[]::new);
    }
}
