package Objects;

import java.math.BigDecimal;

import Enums.ToolCode;

public class Chainsaw extends Tool {
    public Chainsaw(ToolCode toolCode) {
        super(toolCode, "Chainsaw", "Stihl", new BigDecimal("1.99"), false, true);
    }
}