package com.cdk.global.exception;

/**
 * An Exception Class for Invalid Config File.
 */
public class SlabConfigException extends Exception {
  public SlabConfigException() {
    super();
  }

  public SlabConfigException(final String message) {
    super(message);
  }
}
