package com.cdk.global.cart;

import com.cdk.global.exception.InvalidSlabException;
import com.cdk.global.exception.SlabConfigException;
import com.cdk.global.manager.DiscountManager;

/**
 * This class represents a Shopping Cart with its purchase amount and discount manager.
 */
public class ShoppingCart {
  private DiscountManager discountManager;
  private float purchaseAmount;

  public ShoppingCart(DiscountManager discountManager, float purchaseAmount) {
    this.discountManager = discountManager;
    this.purchaseAmount = purchaseAmount;
  }

  public float getBillAmount()
      throws InvalidSlabException, SlabConfigException {
    return discountManager.calculate(purchaseAmount);
  }
}
