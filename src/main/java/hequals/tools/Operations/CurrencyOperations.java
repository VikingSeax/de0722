package hequals.tools.Operations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class CurrencyOperations {

  public static BigDecimal calculatePreDiscountCharge(BigDecimal dailyCharge, int chargeDays) {
    return dailyCharge.multiply(new BigDecimal(chargeDays));
  }

  public static BigDecimal calculateDiscountAmount(BigDecimal preDiscountCharge, BigDecimal discountPercentage) {
    /*
     * To calculate this, we must be careful not to lose accuracy.
     * Multiply the two parameters, precision of the result may or may not have
     * increased, though the scales should be the same.
     * Next we shift the decimal point 2 to the left, effectively dividing by 100.
     * In all cases the scale of the new number
     * should now be 4. This value gets stored for later steps. Return a value that
     * is rounded to the n - 2 precision, where
     * n is the precision of the result. This should yeild a value still with scale
     * 2, that has any amount of precision to
     * represent the discounted amount.
     */
    BigDecimal unroundedResult = preDiscountCharge.multiply(discountPercentage).movePointLeft(2);
    return unroundedResult.round(new MathContext(unroundedResult.precision() - 2, RoundingMode.HALF_UP));
  }

  public static BigDecimal calculateFinalCharge(BigDecimal preDiscountCharge, BigDecimal discountAmount) {
    return preDiscountCharge.subtract(discountAmount);
  }

  public static String formatCurrency(BigDecimal amount) {
    return NumberFormat.getCurrencyInstance().format(amount);
  }
}
