package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.problem1.exceptions.AliasAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MediaLibraryTest {

  private MediaLibrary testMediaLibrary;
  private MediaLibrary testMediaLibrary2;
  private String title = "TitleOfMedia";
  private Integer releaseDate = 2019;
  private List<String> directors = Arrays.asList("Director1", "Director2", "Director3");
  private List<String> mainActors = Arrays.asList("MainActor1", "MainActor2", "MainActor3");
  private Alias alias = new Alias("newAlias");
  private Alias alias2 = new Alias("newAlias2");

  @Before
  public void setUp() throws Exception {

    testMediaLibrary = new MediaLibrary();
    testMediaLibrary2 = new MediaLibrary();
  }

  @Test
  public void createMedia() throws AliasAlreadyExistsException {
    testMediaLibrary.createMedia(title, releaseDate, directors, mainActors, alias);
    assertNotEquals(testMediaLibrary,
        testMediaLibrary2);  // Compare fails since one HashMap has a media, and one does not
  }

  @Test(expected = AliasAlreadyExistsException.class)
  public void createMediaAliasAlreadyFoundFail() throws AliasAlreadyExistsException {
    testMediaLibrary.createMedia(title, releaseDate, directors, mainActors, alias);
    testMediaLibrary.createMedia(title, releaseDate, directors, mainActors, alias);
  }

  @Test
  public void getMediaDirectedBy() throws AliasAlreadyExistsException {
    testMediaLibrary.createMedia(title, releaseDate, directors, mainActors, alias);
    List<Media> returnedList = testMediaLibrary.getMediaDirectedBy("Director1");
    assertEquals(testMediaLibrary.getMediaDirectedBy("Director1"), returnedList);
  }

  @Test
  public void getNumberStreamed() {
    assertEquals(testMediaLibrary.getNumberStreamed(alias), 0, 0);
  }

  @Test
  public void increaseMediaStreams() throws AliasAlreadyExistsException {
    testMediaLibrary.createMedia(title, releaseDate, directors, mainActors, alias);
    testMediaLibrary.increaseMediaStreams(alias, 500);
    assertEquals(testMediaLibrary.getNumberStreamed(alias), 500, 0);
  }

  @Test
  public void getMostStreamed() throws AliasAlreadyExistsException {
    testMediaLibrary.createMedia(title, releaseDate, directors, mainActors, alias);
    testMediaLibrary.createMedia(title, releaseDate, directors, mainActors, alias2);
    testMediaLibrary.increaseMediaStreams(alias, 10);
    testMediaLibrary.increaseMediaStreams(alias2, 500);
    assertEquals(testMediaLibrary.getMostStreamed(), alias2);
  }

  @Test
  public void equals() {
    MediaLibrary testSame = new MediaLibrary();
    assertEquals(testSame, testMediaLibrary);
    assertTrue(testSame.equals(testMediaLibrary));
  }

  @Test
  public void equalsSameSame() {
    MediaLibrary newMediaLibrary = new MediaLibrary();
    assertEquals(newMediaLibrary, new MediaLibrary());
  }

  @Test
  public void equalsNotSameSame() {
    MediaLibrary newMediaLibrary = new MediaLibrary();
    String compareTo = "randomString";
    assertFalse(newMediaLibrary.equals(compareTo));
  }

  @Test
  public void equalsDifferentObject() throws AliasAlreadyExistsException {
    MediaLibrary testDifferent = new MediaLibrary();
    testDifferent.createMedia(title, releaseDate, directors, mainActors, alias);
    assertFalse(testDifferent.equals(testMediaLibrary));
  }

  @Test
  public void testGoodHash() {
    assertEquals(testMediaLibrary.hashCode(), testMediaLibrary2.hashCode());
  }

  @Test
  public void testBadHash() throws AliasAlreadyExistsException {
    testMediaLibrary2.createMedia(title, releaseDate, directors, mainActors, alias);
    assertNotEquals(testMediaLibrary.hashCode(), testMediaLibrary2.hashCode());
  }


}