package com.cdk.global.slabs;

/**
 * This class represents a Discount Slab.
 */
public class Slab implements Comparable<Slab> {
  private int lowerLimit = 0;
  private int upperLimit = Integer.MAX_VALUE;
  private int discountPercent = 0;

  public int getLowerLimit() {
    return lowerLimit;
  }

  public void setLowerLimit(int lowerLimit) {
    this.lowerLimit = lowerLimit;
  }

  public int getUpperLimit() {
    return upperLimit;
  }

  public void setUpperLimit(int upperLimit) {
    this.upperLimit = upperLimit;
  }

  public int getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(int discountPercent) {
    this.discountPercent = discountPercent;
  }

  @Override
  public int compareTo(Slab s) {
    return Integer.compare(this.getLowerLimit(), s.getLowerLimit());
  }
}
