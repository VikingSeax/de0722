package hequals.tools.Objects;

import java.math.BigDecimal;

import hequals.tools.Enums.ToolCode;

public class Chainsaw extends Tool {
  public Chainsaw(ToolCode toolCode) {
    super(toolCode, "Chainsaw", "Stihl", new BigDecimal("1.49"), false, true);
  }
}