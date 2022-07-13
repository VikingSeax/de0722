package src.main.java.hequals.tools.Operations;

import static src.main.java.hequals.tools.Operations.CurrencyOperations.calculateDiscountAmount;
import static src.main.java.hequals.tools.Operations.CurrencyOperations.calculateFinalCharge;
import static src.main.java.hequals.tools.Operations.CurrencyOperations.calculatePreDiscountCharge;
import static src.main.java.hequals.tools.Operations.CurrencyOperations.formatCurrency;
import static src.main.java.hequals.tools.Operations.DateOperations.calculateChargeDays;
import static src.main.java.hequals.tools.Operations.DateOperations.determineDueDate;
import static src.main.java.hequals.tools.Operations.DateOperations.formatDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import src.main.java.hequals.tools.Objects.Tool;

public class RentalAgreementOperations {

    public static String[] printRentalAgreement(Tool tool, int rentalDays, BigDecimal discountPercentage, LocalDate checkOutDate) {
        int chargeDays = calculateChargeDays(tool, checkOutDate, rentalDays);
        BigDecimal preDiscountCharge = calculatePreDiscountCharge(tool.getDailyCharge(), chargeDays);
        BigDecimal discountAmount = calculateDiscountAmount(preDiscountCharge, discountPercentage);
        String[] printOrder = new String[] {"Tool code - " + tool.getToolCode().name(),
                                            "Tool type - " + tool.getToolType(),
                                            "Tool brand - " + tool.getBrand(),
                                            "Rental Days - " + String.valueOf(rentalDays),
                                            "Check out date - " + formatDate(checkOutDate),
                                            "Due date - " + formatDate(determineDueDate(checkOutDate, rentalDays)),
                                            "Daily rental charge - " + formatCurrency(tool.getDailyCharge()),
                                            "Charge days - " + String.valueOf(chargeDays),
                                            "Pre-discount charge - " + formatCurrency(preDiscountCharge),
                                            "Discount percent - " + discountPercentage.toPlainString() + "%",
                                            "Discount amount - " + formatCurrency(discountAmount),
                                            "Final Charge - " + formatCurrency(calculateFinalCharge(preDiscountCharge, discountAmount))};
        Arrays.asList(printOrder).forEach(System.out::println);
        return printOrder;
    }
}
