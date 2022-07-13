package hequals.tools.Exceptions;

public class InvalidRentalDaysException extends Exception {
  public InvalidRentalDaysException(int days) {
    super(days + " is an invalid number of days to rent.  A rental agreement may only comprise of one or more days");
  }
}