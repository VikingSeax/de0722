package hequals.tools.Testing.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import hequals.tools.Enums.ToolCode;
import hequals.tools.Objects.Chainsaw;
import hequals.tools.Objects.Jackhammer;
import hequals.tools.Objects.Ladder;

public class ConstructorTests {
  Chainsaw chainsaw = new Chainsaw(ToolCode.CHNS);
  Ladder ladder = new Ladder(ToolCode.LADW);
  Jackhammer ridgidJackhammer = new Jackhammer(ToolCode.JAKR);
  Jackhammer deWaltJackhammer = new Jackhammer(ToolCode.JAKD);

  @Test
  public void toolCodeShouldBeCorrect() {
    assertEquals(ToolCode.CHNS, chainsaw.getToolCode());
    assertEquals(ToolCode.LADW, ladder.getToolCode());
    assertEquals(ToolCode.JAKR, ridgidJackhammer.getToolCode());
    assertEquals(ToolCode.JAKD, deWaltJackhammer.getToolCode());
  }

  @Test
  public void toolTypeShouldBeCorrect() {
    assertEquals("Chainsaw", chainsaw.getToolType());
    assertEquals("Ladder", ladder.getToolType());
    assertEquals("Jackhammer", ridgidJackhammer.getToolType());
    assertEquals("Jackhammer", deWaltJackhammer.getToolType());
  }

  @Test
  public void brandShouldBeCorrect() {
    assertEquals("Stihl", chainsaw.getBrand());
    assertEquals("Werner", ladder.getBrand());
    assertEquals("Ridgid", ridgidJackhammer.getBrand());
    assertEquals("DeWalt", deWaltJackhammer.getBrand());
  }

  @Test
  public void dailyChargeShouldBeCorrect() {
    assertEquals(new BigDecimal("1.49"), chainsaw.getDailyCharge());
    assertEquals(new BigDecimal("1.99"), ladder.getDailyCharge());
    assertEquals(new BigDecimal("2.99"), ridgidJackhammer.getDailyCharge());
    assertEquals(new BigDecimal("2.99"), deWaltJackhammer.getDailyCharge());
  }

  @Test
  public void weekendChargeShouldBeCorrect() {
    assertFalse(chainsaw.isWeekendCharge());
    assertTrue(ladder.isWeekendCharge());
    assertFalse(ridgidJackhammer.isWeekendCharge());
    assertFalse(deWaltJackhammer.isWeekendCharge());
  }

  @Test
  public void holidayChargeShouldBeCorrect() {
    assertTrue(chainsaw.isHolidayCharge());
    assertFalse(ladder.isHolidayCharge());
    assertFalse(ridgidJackhammer.isHolidayCharge());
    assertFalse(deWaltJackhammer.isHolidayCharge());
  }
}