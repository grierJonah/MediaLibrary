package edu.neu.ccs.cs5004.problem1;

import edu.neu.ccs.cs5004.problem1.exceptions.AliasAlreadyExistsException;

import java.util.List;

/**
 * An interface for a MediaLibrary.
 */
public interface IMediaLibrary {


  /**
   * Method returns a list of movies and tv shows that are directed by a specific director's If
   * there are multiple movies with by a certain director than the list will be returned showcasing
   * the most recent movies at the front: Ordered by most recent release date.
   *
   * @param name the name of the Director to search for
   * @return a list of movies that are directed by the specific Director
   */
  List<Media> getMediaDirectedBy(String name);


  /**
   * Method allows a company to add and create a new movie to the given list of media based on the
   * given parameters.
   *
   * @param alias an alternate name for the media
   * @param title the title of the media
   * @param releaseDate the release date for the media
   * @param directors a list of directors
   * @param mainActors a list of main actors
   * @throws AliasAlreadyExistsException Throws exception if Alias is already found in the hash map
   */
  void createMedia(String title, Integer releaseDate,
      List<String> directors, List<String> mainActors, Alias alias)
      throws AliasAlreadyExistsException;

  /**
   * Method returns value regarding the number of times a certain movie or tv show has been streamed
   * by viewers.
   *
   * @param alias the name of the movie or tv show
   * @return an Integer value
   */
  Integer getNumberStreamed(Alias alias);

  /**
   * Method returns the most streamed / viewed media that the company offers.
   *
   * @return the most streamed media
   */
  Alias getMostStreamed();

  /**
   * Allows the company to set the number of streams a particular media in the mediaLibrary has.
   *
   * @param alias the alias to search the media library for
   * @param numberOfStreams number of streams
   */
  void increaseMediaStreams(Alias alias, Integer numberOfStreams);


}
