package Utils;

import Utils.Err.Err;

import java.math.BigDecimal;

public final class Utils {

    private Utils() {
    }

    public static double roundNumber(double number, int decimalPlaces) {
        return BigDecimal.valueOf(number).setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String isStringNullOrEmpty(String string) {
        return (string == null || string.trim().isEmpty()) ? "" : string;
    }

    public static String isStringNullOrEmptyWithErr(String string) throws Err {
        if (string != null && !string.trim().isEmpty()) {
            return string;
        } else {
            throw new Err("User string is empty");
        }
    }
}
