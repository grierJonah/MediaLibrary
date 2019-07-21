package edu.neu.ccs.cs5004.problem1.sorting;

import edu.neu.ccs.cs5004.problem1.Media;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A class to help order a MediaLibrary by release dates. Takes two Media
 * objects with release dates and returns the correct descending order.
 * Example) 2019, 2018, 2017..
 */
public class OrderByReleaseDate implements Comparator<Media>, Serializable {
  // Removes serializable bug. Allows Comparator to be serialized and de-serialized
  // for different serializers. Example)  
  private static final long serialVersionUID = 1;

  @Override
  public int compare(Media media1, Media media2) {
    return media1.getReleaseDate().compareTo(media2.getReleaseDate());
  }
}
