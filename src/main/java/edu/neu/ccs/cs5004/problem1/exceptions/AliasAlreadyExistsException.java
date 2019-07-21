package edu.neu.ccs.cs5004.problem1.exceptions;

/**
 * An Exception class to help track media Aliases.
 */
public class AliasAlreadyExistsException extends Exception {

  /**
   * Exception thrown if there is already an Alias in the media library collection with the same
   * name.
   *
   * @param msg the message
   */
  public AliasAlreadyExistsException(String msg) {
    super(msg);
  }
}
