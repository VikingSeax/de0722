package hequals.tools.Operations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class CurrencyOperations {

  public static BigDecimal calculateDiscountAmount(BigDecimal preDiscountCharge, BigDecimal discountPercentage) {
    /*
     * To calculate this, we must be careful not to lose accuracy. Multiply the two parameters, the scale
     * should be the same.  Next we shift the decimal point 2 to the left, effectively dividing by 100.
     * In all cases the scale of the new number should now be 4. Then set scale to two, rounding half up and return.
     */
    return preDiscountCharge.multiply(discountPercentage).movePointLeft(2).setScale(2, RoundingMode.HALF_UP);
  }

  public static BigDecimal calculateFinalCharge(BigDecimal preDiscountCharge, BigDecimal discountAmount) {
    return preDiscountCharge.subtract(discountAmount);
  }

  public static BigDecimal calculatePreDiscountCharge(BigDecimal dailyCharge, int chargeDays) {
    return dailyCharge.multiply(new BigDecimal(chargeDays));
  }

  public static String formatCurrency(BigDecimal amount) {
    return NumberFormat.getCurrencyInstance().format(amount);
  }
}
