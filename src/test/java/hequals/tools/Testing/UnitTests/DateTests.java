package hequals.tools.Testing.UnitTests;

import static hequals.tools.Operations.DateOperations.calculateHolidays;
import static hequals.tools.Operations.DateOperations.calculateWeekendDays;
import static hequals.tools.Operations.DateOperations.determineDueDate;
import static hequals.tools.Operations.DateOperations.formatDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DateTests {

  public static Stream<Arguments> provideSourceForTestCalculateHolidays() {
    return Stream.of(
      Arguments.of(1, LocalDate.of(2015, 9, 3), 5),
      Arguments.of(3, LocalDate.of(2015, 9, 3), 400),
      Arguments.of(1, LocalDate.of(2020, 7, 2), 3)
    );
  }
  
  @ParameterizedTest
  @MethodSource("provideSourceForTestCalculateHolidays")
  public void testCalculateHolidays(int expected, LocalDate checkOutDate, int days) {
    assertEquals(expected, calculateHolidays(checkOutDate, days));
  }

  public static Stream<Arguments> provideSourceForTestCalculateWeekendDays() {
    return Stream.of(
      Arguments.of(2, LocalDate.of(2015, 9, 3), 5),
      Arguments.of(114, LocalDate.of(2015, 9, 3), 400)
    );
  }

  @ParameterizedTest
  @MethodSource("provideSourceForTestCalculateWeekendDays")
  public void testCalculateWeekendDays(int expected, LocalDate checkOutDate, int days) {
    assertEquals(expected, calculateWeekendDays(checkOutDate, days));
  }

  public static Stream<Arguments> provideSourceForTestDetermineDueDate() {
    return Stream.of(
      Arguments.of(LocalDate.of(2015, 9, 8), LocalDate.of(2015, 9, 3), 5),
      Arguments.of(LocalDate.of(2016, 10, 7), LocalDate.of(2015, 9, 3), 400)
    );
  }

  @ParameterizedTest
  @MethodSource("provideSourceForTestDetermineDueDate")
  public void testDetermineDueDate(LocalDate expected, LocalDate checkOutDate, int days) {
    assertEquals(expected, determineDueDate(checkOutDate, days));
  }
  
  public static Stream<Arguments> provideSourceForTestFormatDate() {
    return Stream.of(
      Arguments.of("09/03/15", LocalDate.of(2015, 9, 3)),
      Arguments.of("07/02/20", LocalDate.parse("7/2/20", DateTimeFormatter.ofPattern("M/d/yy")))
    );
  }

  @ParameterizedTest
  @MethodSource("provideSourceForTestFormatDate")
  public void testFormatDate(String expected, LocalDate date) {
    assertEquals(expected, formatDate(date));
  }
}
