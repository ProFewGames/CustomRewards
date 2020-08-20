package xyz.ufactions.customrewards.libs;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class UtilMath {

    public static boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String paramString) {
        try {
            Integer.parseInt(paramString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double trim(int degree, double d) {
        String format = "#.#";

        for (int i = 1; i < degree; i++)
            format += "#";

        DecimalFormatSymbols symb = new DecimalFormatSymbols(Locale.US);
        DecimalFormat twoDForm = new DecimalFormat(format, symb);
        return Double.parseDouble(twoDForm.format(d));
    }

    public static int round(int num) {
        return (num / 9 + ((num % 9 == 0) ? 0 : 1)) * 9;
    }

    public static Random random = new Random();

    public static int r(int i) {
        return random.nextInt(i);
    }
}