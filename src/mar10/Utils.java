package mar10;

import java.math.BigDecimal;

public final class Utils {

    private Utils() { }

    public static double roundNumber(double number, int decimalPlaces) {
        return BigDecimal.valueOf(number).setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

