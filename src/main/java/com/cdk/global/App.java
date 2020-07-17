package com.cdk.global;

import com.cdk.global.cart.ShoppingCart;
import com.cdk.global.exception.InvalidSlabException;
import com.cdk.global.exception.SlabConfigException;
import com.cdk.global.manager.SlabManager;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.print("Please enter purchase amount: ");
    Scanner input = new Scanner(System.in);
    float purchaseAmount = input.nextFloat();

    ShoppingCart shoppingCart =
        new ShoppingCart(new SlabManager("Slabs.json"), purchaseAmount);
    
    try {
      System.out.println("Final bill amount = " +
          Math.round(shoppingCart.getBillAmount()));
    } catch (InvalidSlabException e) {
      System.err.println("Overlapping slabs in config file. Please check.");
    } catch (SlabConfigException e) {
      System.err.println("Something is wrong with Slab Config file. Please check.");
    }
  }
}
