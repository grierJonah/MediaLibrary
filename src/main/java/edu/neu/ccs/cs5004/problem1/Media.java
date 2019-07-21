package edu.neu.ccs.cs5004.problem1;

import java.util.List;

/**
 * A Media class.
 */
public class Media {

  private String title;
  private Integer releaseDate;
  private List<String> directors;
  private List<String> mainActors;
  private Integer numberOfStreams;

  /**
   * Constructs a new piece of media with the given parameters. A media can be a tv-show or movie.
   *
   * @param title the title of the media
   * @param releaseDate the release date it was published on
   * @param directors list of directors
   * @param mainActors list of actors
   */
  public Media(String title, Integer releaseDate, List<String> directors,
      List<String> mainActors) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.directors = directors;
    this.mainActors = mainActors;
    this.numberOfStreams = 0;
  }

  /**
   * Gets a list of directors who worked on the media.
   *
   * @return a list of directors
   */
  public List<String> getDirectors() {
    return directors;
  }

  /**
   * Gets the title of the media.
   *
   * @return the title of the media
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the date the media was released.
   *
   * @return the date the media was released
   */
  public Integer getReleaseDate() {
    return releaseDate;
  }

  /**
   * Method allows a company to get the number of streams.
   *
   * @return the number of views/streams
   */
  public Integer getNumberOfStreams() {
    return numberOfStreams;
  }

  /**
   * Allows a company to set a media's number of streams / views.
   *
   * @param numStreams the number of streams / views to set too
   */
  public void setNumberOfStreams(Integer numStreams) {
    this.numberOfStreams = numStreams;
  }

  /**
   * Allows a company to get the media's main actors.
   *
   * @return a list of main actors
   */
  public List<String> getMainActors() {
    return mainActors;
  }
}
