package Operations;

public class CurrencyOperations {
    public static double calculatePreDiscountCharge(float dailyCharge, int chargeDays) {
        return dailyCharge * chargeDays;
    }

    public static double calculateDiscountAmount (double preDiscountCharge, int discountPercentage) {
        /*  discount percentage is represented as an integer, so the multiplication by 100 that normally needs to happen
            when rounding to two decimal points is already factored in through the percentage value */
        return (double) Math.round(preDiscountCharge * discountPercentage) / 100;
    }

    public static double calculateFinalCharge (double preDiscountCharge, double discountAmount) {
        return preDiscountCharge - discountAmount;
    }
}
