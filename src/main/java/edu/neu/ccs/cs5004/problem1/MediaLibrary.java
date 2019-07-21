package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem1.exceptions.AliasAlreadyExistsException;
import edu.neu.ccs.cs5004.problem1.sorting.OrderByReleaseDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A mediaLibrary consisting of Media objects. MediaLibrary is the companies way to access the media
 * they want/need.
 */
public class MediaLibrary implements IMediaLibrary {


  private HashMap<Alias, Media> mediaLibraryMap;

  /**
   * Constructs a new Media Library with a piece of media.
   */
  public MediaLibrary() {
    mediaLibraryMap = new HashMap<>();
  }

  /**
   * Method allows a company to add and create a new movie to the given list of media based on the
   * given parameters.
   *
   * @param alias an alternate name for the media
   * @param title the title of the media
   * @param releaseDate the release date for the media
   * @param directors a list of directors
   * @param mainActors a list of main actors
   */
  public void createMedia(String title, Integer releaseDate,
      List<String> directors, List<String> mainActors, Alias alias)
      throws AliasAlreadyExistsException {
    Media newMedia = new Media(title, releaseDate, directors, mainActors);
    if (!this.mediaLibraryMap.containsKey(alias)) {
      mediaLibraryMap.put(alias, newMedia);
    } else {
      throw new AliasAlreadyExistsException("Alias already exists. Try again with new alias.");
    }
  }

  /**
   * Method returns a sorted list of movies that are directed by a specific director's name. If
   * there are multiple movies found by a certain director than the list will be returned showcasing
   * the most recent movies at the front: Ordered by most recent release date.
   *
   * @param name the name of the Director to search for
   * @return a list of movies that are directed by the specific Director
   */
  public List<Media> getMediaDirectedBy(String name) {
    List<Media> listOfMedia = new ArrayList<>();                       // new list to sort
    for (Map.Entry<Alias, Media> entry : mediaLibraryMap.entrySet()) {
      if (entry.getValue().getDirectors().contains(name)) {
        listOfMedia.add(entry.getValue());
      }
    }
    listOfMedia.sort(new OrderByReleaseDate());
    return listOfMedia;
  }

  /**
   * Method returns value regarding the number of times a certain movie or tv show has been streamed
   * by viewers.
   *
   * @param alias the name of the movie or tv show
   * @return an Integer value
   */
  @Override
  public Integer getNumberStreamed(Alias alias) {
    if (mediaLibraryMap.containsKey(alias)) {
      return mediaLibraryMap.get(alias).getNumberOfStreams();
    }
    return 0;
  }


  /**
   * Method increases the specific media's stream count given an alias and a number to increase
   * too.
   *
   * @param alias the alias to search the media library for
   * @param numberOfStreams number of streams
   */
  public void increaseMediaStreams(Alias alias, Integer numberOfStreams) {
    if (mediaLibraryMap.containsKey(alias)) {
      mediaLibraryMap.put(alias, mediaLibraryMap.get(alias)).setNumberOfStreams(numberOfStreams);
    }
  }

  /**
   * Method returns the most streamed / viewed media that the company offers.
   *
   * @return the most streamed media
   */
  @Override
  public Alias getMostStreamed() {
    Integer mostStreamed = 0;
    Alias maxAlias = null;
    for (Map.Entry<Alias, Media> entry : mediaLibraryMap.entrySet()) {
      if (entry.getValue().getNumberOfStreams() > mostStreamed) {
        mostStreamed = entry.getValue().getNumberOfStreams();
        maxAlias = entry.getKey();
      }
    }
    return maxAlias;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    MediaLibrary that = (MediaLibrary) obj;
    return Objects.equals(mediaLibraryMap, that.mediaLibraryMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaLibraryMap);
  }
}

