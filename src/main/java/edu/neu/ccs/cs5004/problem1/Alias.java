package edu.neu.ccs.cs5004.problem1;

/**
 * A simple class for an Alias.
 */
public class Alias {

  private String mediaAlias;

  /**
   * Constructs a new Alias given the parameters.
   *
   * @param alias an alternate name for a media
   */
  public Alias(String alias) {
    this.mediaAlias = alias;
  }

  /**
   * Returns the media's alias. Implemented this method to remove the URF
   * (UNF_UNREAD_FIELD) bug. Using this method is never used, however, can be utilized
   * if the company wants to check that map's key matches this alias.
   *
   * @return the media's alias.
   */
  public String getMediaAlias() {
    return mediaAlias;
  }
}
