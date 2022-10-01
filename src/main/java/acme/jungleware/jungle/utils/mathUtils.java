package acme.jungleware.jungle.utils;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class mathUtils {
    public static double roundToPlace(double value, int place) {
        if (place < 0) {
            return value;
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
