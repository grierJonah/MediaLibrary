package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MediaTest {

  Media testMedia;
  List<String> directors;
  List<String> mainActors;

  @Before
  public void setUp() {
    directors = Arrays.asList("Director1", "Director2", "Director3");
    mainActors = Arrays.asList("MainActor1", "MainActor2", "MainActor3");
    testMedia = new Media("Movie1", 2019, directors, mainActors);
  }

  @Test
  public void getDirectors() {
    assertEquals(testMedia.getDirectors(), directors);
  }

  @Test
  public void getTitle() {
    assertEquals(testMedia.getTitle(), "Movie1");
  }

  @Test
  public void getReleaseDate() {
    assertEquals(testMedia.getReleaseDate(), 2019, 0);
  }

  @Test
  public void getNumberOfStreams() {
    assertEquals(testMedia.getNumberOfStreams(), 0, 0);
  }

  @Test
  public void setNumberOfStreams() {
    testMedia.setNumberOfStreams(10);
    assertEquals(testMedia.getNumberOfStreams(), 10, 0);
  }

  @Test
  public void getMainActors() {
    assertEquals(testMedia.getMainActors(), mainActors);
  }
}