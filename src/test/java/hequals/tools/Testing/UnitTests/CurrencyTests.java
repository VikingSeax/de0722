package hequals.tools.Testing.UnitTests;

import static hequals.tools.Operations.CurrencyOperations.calculateDiscountAmount;
import static hequals.tools.Operations.CurrencyOperations.calculateFinalCharge;
import static hequals.tools.Operations.CurrencyOperations.calculatePreDiscountCharge;
import static hequals.tools.Operations.CurrencyOperations.formatCurrency;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CurrencyTests {
  
  public static Stream<Arguments> provideSourceForTestCalculateDiscountAmount() {
    return Stream.of(
      Arguments.of(new BigDecimal("0.00"), new BigDecimal("24.99"), new BigDecimal("0")),
      Arguments.of(new BigDecimal("0.25"), new BigDecimal("24.99"), new BigDecimal(1)),
      Arguments.of(new BigDecimal("24.99"), new BigDecimal("24.99"), new BigDecimal(100)),
      Arguments.of(new BigDecimal("0.01"), new BigDecimal("1.49"), new BigDecimal(1)),
      Arguments.of(new BigDecimal("12.39"), new BigDecimal("123.85"), new BigDecimal(10))
    );
  }

  @ParameterizedTest
  @MethodSource("provideSourceForTestCalculateDiscountAmount")
  public void testCalculateDiscountAmount(BigDecimal expected, BigDecimal charge, BigDecimal percentage) {
    assertEquals(expected, calculateDiscountAmount(charge, percentage));
  }

  public static Stream<Arguments> provideSourceForTestCalculateFinalCharge() {
    return Stream.of(
      Arguments.of(new BigDecimal("0.00"), new BigDecimal("24.99"), new BigDecimal("24.99")),
      Arguments.of(new BigDecimal("24.99"), new BigDecimal("24.99"), new BigDecimal("0.00")),
      Arguments.of(new BigDecimal("14.62"), new BigDecimal("24.99"), new BigDecimal("10.37"))
    );
  }

  @ParameterizedTest
  @MethodSource("provideSourceForTestCalculateFinalCharge")
  public void testCalculateFinalCharge(BigDecimal expected, BigDecimal charge, BigDecimal discountAmount) {
    assertEquals(expected, calculateFinalCharge(charge, discountAmount));
  }


  public static Stream<Arguments> provideSourceForTestCalculatePreDiscountCharge() {
    return Stream.of(
      Arguments.of(new BigDecimal("44.85"), new BigDecimal("2.99"), 15),
      Arguments.of(new BigDecimal("29.80"), new BigDecimal("1.49"), 20)
    );
  }

  @ParameterizedTest
  @MethodSource("provideSourceForTestCalculatePreDiscountCharge")
  public void testCalculatePreDiscountCharge(BigDecimal expected, BigDecimal dailyCharge, int chargeDays) {
    assertEquals(expected, calculatePreDiscountCharge(dailyCharge, chargeDays));
  }

  public static Stream<Arguments> provideSourceForTestFormatCurrency() {
    return Stream.of(
      Arguments.of("$0.00", new BigDecimal("0.00")),
      Arguments.of("$1.49", new BigDecimal("1.49")),
      Arguments.of("$1,000.00", new BigDecimal("1000.00")),
      Arguments.of("$1,000,000.00", new BigDecimal("1000000.00"))
    );
  }

  @ParameterizedTest
  @MethodSource("provideSourceForTestFormatCurrency")
  public void testFormatCurrency(String expected, BigDecimal value) {
    assertEquals(expected, formatCurrency(value));
  }
}