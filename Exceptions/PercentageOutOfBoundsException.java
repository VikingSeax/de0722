package Exceptions;

import java.math.BigDecimal;

public class PercentageOutOfBoundsException extends Exception {
    public PercentageOutOfBoundsException(BigDecimal percentage) {
        super(percentage.toPlainString() + "% is an invalid percentage, the percentage must be between 0 and 100.");
    }
}
