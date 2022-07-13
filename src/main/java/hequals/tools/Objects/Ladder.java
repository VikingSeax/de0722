package src.main.java.hequals.tools.Objects;

import java.math.BigDecimal;

import src.main.java.hequals.tools.Enums.ToolCode;

public class Ladder extends Tool {
  public Ladder(ToolCode toolCode) {
    super(toolCode, "Ladder", "Werner", new BigDecimal("1.99"), true, false);
  }
}
