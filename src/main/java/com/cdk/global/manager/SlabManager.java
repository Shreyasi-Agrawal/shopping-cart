package com.cdk.global.manager;

import com.cdk.global.exception.InvalidSlabException;
import com.cdk.global.exception.SlabConfigException;
import com.cdk.global.slabs.Slab;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An implementation of DiscountManager. This class represents one of the possible kinds of Discount,
 * which is Slab discount.
 */
public class SlabManager implements DiscountManager {

  private List<Slab> discountSlabs;
  private String filePath;

  public SlabManager(String filePath) {
    this.filePath = filePath;
  }

  public float calculate(final float purchaseAmount)
      throws InvalidSlabException, SlabConfigException {

    loadSlabsFromConfig(filePath);

    if (!validateSlabs()) {
      throw new InvalidSlabException("Overlapping slabs in config file. Please check.");
    }

    float amount = purchaseAmount;
    float discount = 0;

    for(Slab slab: discountSlabs) {
      if (amount < 0) {
        break;
      }
      if (purchaseAmount > slab.getLowerLimit()) {
        float amountForDiscount = Math.min(amount, (slab.getUpperLimit() - slab.getLowerLimit()));
        discount += (slab.getDiscountPercent() * amountForDiscount) / 100;
        amount -= amountForDiscount;
      }
    }

    return purchaseAmount - discount;
  }

  private void loadSlabsFromConfig(final String filePath) throws SlabConfigException {
    discountSlabs = new ArrayList<>();

    File slabFile = new File(getClass().getClassLoader().getResource(filePath).getFile());

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      discountSlabs = Arrays.asList(objectMapper.readValue(slabFile, Slab[].class));
      Collections.sort(discountSlabs);
    } catch (IOException e) {
      e.printStackTrace();
      throw new SlabConfigException("Something is wrong with Slab Config file. Please check.");
    }
  }

  private boolean validateSlabs() {
    for(int i = 0; i < discountSlabs.size() - 1; i++) {
      if (discountSlabs.get(i).getUpperLimit() > discountSlabs.get(i + 1).getLowerLimit()) {
        return false;
      }
    }
    return true;
  }
}
