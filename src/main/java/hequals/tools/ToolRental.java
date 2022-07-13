package hequals.tools;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import hequals.tools.Enums.ToolCode;
import hequals.tools.Exceptions.InvalidRentalDaysException;
import hequals.tools.Exceptions.PercentageOutOfBoundsException;
import hequals.tools.Objects.Chainsaw;
import hequals.tools.Objects.Jackhammer;
import hequals.tools.Objects.Ladder;
import hequals.tools.Objects.Tool;
import hequals.tools.Operations.RentalAgreementOperations;

public class ToolRental {
  public static void main(String[] args) {
    String toolCode = "";
    String rentalDays = "";
    String discountPercentage = "";
    String checkOutDate = "";

    System.out.print("Tool code - ");
    toolCode = System.console().readLine();
    System.out.print("Rental day count - ");
    rentalDays = System.console().readLine();
    System.out.print("Discount percent - ");
    discountPercentage = System.console().readLine();
    System.out.print("Check out date - ");
    checkOutDate = System.console().readLine();

    try {
      checkValuesAndProceed(ToolCode.valueOf(toolCode), Integer.parseInt(rentalDays),
          new BigDecimal(discountPercentage), LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("M/d/yy")));
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    } catch (DateTimeParseException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static String[] checkValuesAndProceed(ToolCode toolCode, int rentalDays, BigDecimal discountPercentage,
      LocalDate checkOutDate) throws InvalidRentalDaysException, PercentageOutOfBoundsException {
    // checks if the rental days are less than 1, and throws an exception if so
    if (rentalDays < 1)
      throw new InvalidRentalDaysException(rentalDays);
    // checks if the discount percentage is less than zero, or larger than 100, and
    // throws an exception if so
    if (discountPercentage.compareTo(BigDecimal.ZERO) == -1 || discountPercentage.compareTo(new BigDecimal(100)) == 1)
      throw new PercentageOutOfBoundsException(discountPercentage);

    Tool tool;
    switch (toolCode.name().charAt(0)) {
      case 'L':
        tool = new Ladder(toolCode);
        break;
      case 'J':
        tool = new Jackhammer(toolCode);
        break;
      case 'C':
        tool = new Chainsaw(toolCode);
        break;
      default:
        tool = new Tool();
        break;
    }

    return RentalAgreementOperations.printRentalAgreement(tool, rentalDays, discountPercentage, checkOutDate);
  }
}