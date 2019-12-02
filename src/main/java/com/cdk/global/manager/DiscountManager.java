package com.cdk.global.manager;

import com.cdk.global.exception.InvalidSlabException;
import com.cdk.global.exception.SlabConfigException;

public interface DiscountManager {

  /**
   * This method takes purchaseAmount as argument and returns the discounted amount.
   * @param purchaseAmount Purchase Amount
   * @return Final Bill Amount
   * @throws InvalidSlabException in case slabs are invalid
   * @throws SlabConfigException in case slab config file is invalid
   */
  float calculate(float purchaseAmount) throws InvalidSlabException, SlabConfigException;
}
