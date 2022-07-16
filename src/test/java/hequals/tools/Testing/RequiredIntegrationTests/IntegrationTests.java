package hequals.tools.Testing.RequiredIntegrationTests;

import static hequals.tools.ToolRental.checkValuesAndProceed;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import hequals.tools.Enums.ToolCode;
import hequals.tools.Exceptions.InvalidRentalDaysException;
import hequals.tools.Exceptions.PercentageOutOfBoundsException;

public class IntegrationTests {
  
  @Test
  public void testOne() {
    assertThrows(PercentageOutOfBoundsException.class, () -> {
      checkValuesAndProceed(ToolCode.JAKR, 5, new BigDecimal("101"), LocalDate.of(2015, 9, 3));
    });
  }

  @Test
  public void testTwo() throws InvalidRentalDaysException, PercentageOutOfBoundsException { //throws is for the warning I was getting, can't bear the sight of red
    String[] expected = new String[]{
      "Tool code - LADW",
      "Tool type - Ladder",
      "Tool brand - Werner",
      "Rental days - 3",
      "Check out date - 07/02/20",
      "Due date - 07/05/20",
      "Daily rental charge - $1.99",
      "Charge days - 2",
      "Pre-discount charge - $3.98",
      "Discount percent - 10%",
      "Discount amount - $0.40",
      "Final charge - $3.58"
    };
    assertArrayEquals(
      expected,
      checkValuesAndProceed(ToolCode.LADW, 3, new BigDecimal("10"), LocalDate.of(2020, 7, 2))
    );
  }

  @Test
  public void testThree() throws InvalidRentalDaysException, PercentageOutOfBoundsException {
    String[] expected = new String[]{
      "Tool code - CHNS",
      "Tool type - Chainsaw",
      "Tool brand - Stihl",
      "Rental days - 5",
      "Check out date - 07/02/15",
      "Due date - 07/07/15",
      "Daily rental charge - $1.49",
      "Charge days - 3",
      "Pre-discount charge - $4.47",
      "Discount percent - 25%",
      "Discount amount - $1.12",
      "Final charge - $3.35"
    };
    assertArrayEquals(
      expected,
      checkValuesAndProceed(ToolCode.CHNS, 5, new BigDecimal("25"), LocalDate.of(2015, 7, 2))
    );
  }

  @Test
  public void testFour() throws InvalidRentalDaysException, PercentageOutOfBoundsException {
    String[] expected = new String[]{
      "Tool code - JAKD",
      "Tool type - Jackhammer",
      "Tool brand - DeWalt",
      "Rental days - 6",
      "Check out date - 09/03/15",
      "Due date - 09/09/15",
      "Daily rental charge - $2.99",
      "Charge days - 3",
      "Pre-discount charge - $8.97",
      "Discount percent - 0%",
      "Discount amount - $0.00",
      "Final charge - $8.97"
    };
    assertArrayEquals(
      expected,
      checkValuesAndProceed(ToolCode.JAKD, 6, new BigDecimal("0"), LocalDate.of(2015, 9, 3))
    );
  }

  @Test
  public void testFive() throws InvalidRentalDaysException, PercentageOutOfBoundsException {
    String[] expected = new String[]{
      "Tool code - JAKR",
      "Tool type - Jackhammer",
      "Tool brand - Ridgid",
      "Rental days - 9",
      "Check out date - 07/02/15",
      "Due date - 07/11/15",
      "Daily rental charge - $2.99",
      "Charge days - 5",
      "Pre-discount charge - $14.95",
      "Discount percent - 0%",
      "Discount amount - $0.00",
      "Final charge - $14.95"
    };
    assertArrayEquals(
      expected,
      checkValuesAndProceed(ToolCode.JAKR, 9, new BigDecimal("0"), LocalDate.of(2015, 7, 2))
    );
  }

  @Test
  public void testSix() throws InvalidRentalDaysException, PercentageOutOfBoundsException {
    String[] expected = new String[]{
      "Tool code - JAKR",
      "Tool type - Jackhammer",
      "Tool brand - Ridgid",
      "Rental days - 4",
      "Check out date - 07/02/20",
      "Due date - 07/06/20",
      "Daily rental charge - $2.99",
      "Charge days - 1",
      "Pre-discount charge - $2.99",
      "Discount percent - 50%",
      "Discount amount - $1.50",
      "Final charge - $1.49"
    };
    assertArrayEquals(
      expected,
      checkValuesAndProceed(ToolCode.JAKR, 4, new BigDecimal("50"), LocalDate.of(2020, 7, 2))
    );
  }

}
