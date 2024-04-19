package andre.chamis.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private static void printMessage(String message) {
        System.out.print(message);
    }

    public static String getStringInput(String message) {
        try {
            printMessage(message);
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Insira um valor textual válido!");
            return getStringInput(message);
        }
    }

    public static BigDecimal getBigDecimalInput(String message) {
        try {
            printMessage(message);
            BigDecimal valor = scanner.nextBigDecimal();
            scanner.nextLine();
            return valor;
        } catch (Exception e) {
            System.out.println("Insira um número decimal válido! Use (,) como separador decimal");
            scanner.nextLine();
            return getBigDecimalInput(message);
        }
    }

    public static Integer getIntegerInput(String message) {
        try {
            printMessage(message);
            Integer valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (Exception e) {
            System.out.println("Insira um número válido!");
            scanner.nextLine();
            return getIntegerInput(message);
        }
    }

    public static Date getDateInput(String message) {
        SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");

        if (!message.endsWith(" (MM/AAAA): ")) {
            message = message.replace(":", "") + " (MM/AAAA): ";
        }

        try {
            printMessage(message);
            return df.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Insira uma data válida!");
            return getDateInput(message);
        }
    }

    public static String[] getStringArrayInput(String message) {
        List<String> strings = new ArrayList<>();

        String val;
        System.out.println(message);
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
