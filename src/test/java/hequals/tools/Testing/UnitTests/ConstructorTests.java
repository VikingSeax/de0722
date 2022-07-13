package hequals.tools.Testing.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import hequals.tools.Enums.ToolCode;
import hequals.tools.Objects.Chainsaw;
import hequals.tools.Objects.Jackhammer;
import hequals.tools.Objects.Ladder;
import hequals.tools.Objects.Tool;

public class ConstructorTests {
  Chainsaw chainsaw = new Chainsaw(ToolCode.CHNS);
  Ladder ladder = new Ladder(ToolCode.LADW);
  Jackhammer ridgidJackhammer = new Jackhammer(ToolCode.JAKR);
  Jackhammer deWaltJackhammer = new Jackhammer(ToolCode.JAKD);

  @Test
  public void jackhammerShouldBeDeWalt() {
    assertEquals(deWaltJackhammer.getBrand(), "DeWalt");
  }

  @Test
  public void jackhammerShouldBeRidgid() {
    assertEquals(ridgidJackhammer.getBrand(), "Ridgid");
  }
}