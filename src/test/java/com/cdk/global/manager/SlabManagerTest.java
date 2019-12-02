package com.cdk.global.manager;

import static org.junit.Assert.assertEquals;

import com.cdk.global.exception.InvalidSlabException;
import com.cdk.global.exception.SlabConfigException;
import org.junit.Test;

public class SlabManagerTest {

  private SlabManager slabManager;

  @Test
  public void testCalculateWithValidSlabs() throws InvalidSlabException, SlabConfigException {
    slabManager = new SlabManager("SlabsTest-1.json");
    float billAmount = slabManager.calculate(4000);
    assertEquals(4000, billAmount, 0);

    billAmount = slabManager.calculate(8000);
    assertEquals(7700, billAmount, 0);
  }

  @Test(expected = InvalidSlabException.class)
  public void testCalculateWithInvalidSlabs() throws InvalidSlabException, SlabConfigException {
    slabManager = new SlabManager("SlabsTest-2.json");

    slabManager.calculate(2000);
  }
}
