package edu.neu.ccs.cs5004.problem1.sorting;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.problem1.Alias;
import edu.neu.ccs.cs5004.problem1.Media;
import edu.neu.ccs.cs5004.problem1.MediaLibrary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class OrderByReleaseDateTest {
  private Media cryingKidOnTerryAve;
  private Media pleaseStopCrying;
  private List<Media> listOMedia;
  private List<Media> checkCorrectlyOrdered;

  private Integer releaseDate = 2020;
  private Integer releaseDate2 = 2019;
  private List<String> directors = Arrays.asList("Director1", "Director2", "Director3");
  private List<String> mainActors = Arrays.asList("MainActor1", "MainActor2", "MainActor3");

  @Before
  public void setUp() throws Exception {
    listOMedia = new ArrayList<>();
    checkCorrectlyOrdered = new ArrayList<>();

    cryingKidOnTerryAve = new Media("I forgot my headphones",
        releaseDate, directors, mainActors);
    pleaseStopCrying = new Media("damn", releaseDate2, directors, mainActors);
    listOMedia.add(cryingKidOnTerryAve);
    listOMedia.add(pleaseStopCrying);
  }

  @Test
  public void compare() {
    checkCorrectlyOrdered.add(pleaseStopCrying);
    checkCorrectlyOrdered.add(cryingKidOnTerryAve);

    listOMedia.sort(new OrderByReleaseDate());
    assertEquals(listOMedia, checkCorrectlyOrdered);
  }
}