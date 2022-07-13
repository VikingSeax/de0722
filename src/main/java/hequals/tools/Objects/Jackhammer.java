package src.main.java.hequals.tools.Objects;

import java.math.BigDecimal;

import src.main.java.hequals.tools.Enums.ToolCode;

public class Jackhammer extends Tool {
    public Jackhammer (ToolCode toolCode) {
        super(toolCode, "Jackhammer", toolCode == ToolCode.JAKD ? "DeWalt" : "Ridgid", new BigDecimal("2.99"), false, false);
    }
}
