package cs3500.hw01.publication;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * This class tests the Webpage class using JUnit 4.
 */
public class WebpageTest {

  Publication turing = new Webpage("CS3500: Object-Oriented Design",
      "http://www.ccs.neu.edu/course/cs3500/", "August 11, 2014");

  /**
   * This methods tests that APA citation is done correctly by this particular publication
   * implementation.
   */
  @Test
  public void testCiteApa() {
    assertEquals(
        "CS3500: Object-Oriented Design. Retrieved August 11, 2014, from http://www.ccs.neu.edu/course/cs3500/.",
        turing.citeApa());
  }

  /**
   * This methods tests that MLA citation is done correctly by this particular publication
   * implementation.
   */
  @Test
  public void testCiteMla() {
    assertEquals(
        "\"CS3500: Object-Oriented Design.\" Web. August 11, 2014 <http://www.ccs.neu.edu/course/cs3500/>.",
        turing.citeMla());
  }

}