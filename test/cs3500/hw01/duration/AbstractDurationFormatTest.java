package cs3500.hw01.duration;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for the format method of {@link Duration}s. Add your tests to this class to assure that
 * your format method works properly
 */
public abstract class AbstractDurationFormatTest {

  /**
   * Tests that the %h %m and %s commands work correctly.
   */
  @Test
  public void formatExample1() {
    assertEquals("4 hours, 0 minutes, and 9 seconds",
        hms(4, 0, 9)
            .format("%h hours, %m minutes, and %s seconds"));
  }

  /**
   * Tests that the %M and %S commands work correctly (in addition to testing %h again).
   */
  @Test
  public void formatExample2() {
    assertEquals("4:05:17",
        hms(4, 5, 17).format("%h:%M:%S"));
  }

  /**
   * Tests that the %H command works correctly.
   */
  @Test
  public void testUpperCaseHCommand() {
    assertEquals("04:05:17",
        hms(4, 5, 17).format("%H:%M:%S"));
  }

  /**
   * Tests that the %t command works correctly.
   */
  @Test
  public void testLowerCaseTCommand() {
    assertEquals("in seconds it a total of 14717 secs",
        hms(4, 5, 17).format("in seconds it a total of %t secs"));
  }

  /**
   * Tests that %% command works correctly.
   */
  @Test
  public void testPercentageSignCommand() {
    assertEquals("100% of the time 5 minutes late.",
        hms(4, 5, 17).format("100%% of the time %m minutes late."));
  }

  /**
   * Tests that the function throws and IllegalArgumentException when a null template is given.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTemplate() {
    hms(4, 5, 17).format(null);
  }

  /**
   * Tests that the function throws an IllegalArgumentException when given a malformed command.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMalformedTemplate() {
    hms(4, 5, 17).format("%");
  }

  /**
   * Tests that the function throws an IllegalArgumentException when given a malformed command.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLessObviousMalformedTemplate() {
    hms(4, 5, 17).format("hello %");
  }

  /**
   * Tests that the function works correctly when given a empty template (edge case).
   */
  @Test
  public void testEmptyTemplate() {
    assertEquals("", hms(4, 5, 17).format(""));
  }

  /**
   * Tests that the function works correctly when given a empty template with no commands.
   */
  @Test
  public void testNoCommands() {
    assertEquals("Not everything in is time...",
        hms(4, 5, 17).format("Not everything in is time..."));
  }

  /**TESTING SECS CONSTRUCTION METHOD:*/

  /**
   * Tests that the %h %m and %s commands work correctly.
   */
  @Test
  public void formatExample12() {
    assertEquals("4 hours, 0 minutes, and 9 seconds",
        hms(4, 0, 9)
            .format("%h hours, %m minutes, and %s seconds"));
  }

  /**
   * Tests that the %M and %S commands work correctly (in addition to testing %h again).
   */
  @Test
  public void formatExample22() {
    assertEquals("4:05:17",
        sec(14717).format("%h:%M:%S"));
  }

  /**
   * Tests that the %H command works correctly.
   */
  @Test
  public void testUpperCaseHCommand2() {
    assertEquals("04:05:17",
        sec(14717).format("%H:%M:%S"));
  }

  /**
   * Tests that the %t command works correctly.
   */
  @Test
  public void testLowerCaseTCommand2() {
    assertEquals("in seconds it a total of 14717 secs",
        sec(14717).format("in seconds it a total of %t secs"));
  }

  /**
   * Tests that %% command works correctly.
   */
  @Test
  public void testPercentageSignCommand2() {
    assertEquals("100% of the time 5 minutes late.",
        sec(14717).format("100%% of the time %m minutes late."));
  }

  /**
   * Tests that the function throws and IllegalArgumentException when a null template is given.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullTemplate2() {
    sec(14717).format(null);
  }

  /**
   * Tests that the function throws an IllegalArgumentException when given a malformed command.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMalformedTemplate2() {
    sec(14717).format("%");
  }

  /**
   * Tests that the function throws an IllegalArgumentException when given a malformed command.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLessObviousMalformedTemplate2() {
    sec(14717).format("hello %");
  }

  /**
   * Tests that the function works correctly when given a empty template (edge case).
   */
  @Test
  public void testEmptyTemplate2() {
    assertEquals("", sec(14717).format(""));
  }

  /**
   * Tests that the function works correctly when given a empty template with no commands.
   */
  @Test
  public void testNoCommands2() {
    assertEquals("Not everything in is time...",
        sec(14717).format("Not everything in is time..."));
  }











  

  /*
    Leave this section alone: It contains two abstract methods to
    create Durations, and concrete implementations of this testing class
    will supply particular implementations of Duration to be used within 
    your tests.
   */

  /**
   * Constructs an instance of the class under test representing the duration given in hours,
   * minutes, and seconds.
   *
   * @param hours the hours in the duration
   * @param minutes the minutes in the duration
   * @param seconds the seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration hms(int hours, int minutes, int seconds);

  /**
   * Constructs an instance of the class under test representing the duration given in seconds.
   *
   * @param inSeconds the total seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration sec(long inSeconds);

  public static final class HmsDurationTest extends AbstractDurationFormatTest {

    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new HmsDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new HmsDuration(inSeconds);
    }
  }

  public static final class CompactDurationTest extends AbstractDurationFormatTest {

    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new CompactDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new CompactDuration(inSeconds);
    }
  }
}
