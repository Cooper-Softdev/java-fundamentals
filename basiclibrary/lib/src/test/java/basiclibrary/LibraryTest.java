package basiclibrary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
  @Test
  void rollTest() {
    Library sut = new Library();
    int[] actualOutput = sut.roll(6);

    for (int roll : actualOutput) {
      assertTrue(roll >= 1 && roll <= 6, "Each roll should be between 1 and 6 INCLUSIVE");
    }
  }

  @Test
  void containsDuplicatesTest() {
    Library sut = new Library();
    int[] testOne = {1, 3, 4, 7, 9};
    int[] testTwo = {1, 3, 4, 7, 3};

    assertFalse(sut.containsDuplicates(testOne), "Should return false");
    assertTrue(sut.containsDuplicates(testTwo), "Should return true");
  }

  @Test
  void averageTest() {
    Library sut = new Library();
    int[] testOne = {1, 3, 4, 7, 9};
    int[] testTwo = {1, 3, 4, 7, 3};
    double actualOutputOne = sut.average(testOne);
    double actualOutputTwo = sut.average(testTwo);

    assertTrue(actualOutputOne > 4 && actualOutputOne < 5, "Average is 4.8");
    assertTrue(actualOutputTwo > 3 && actualOutputTwo < 4, "Average is 3.6");
  }

  @Test
  void lowestAverageTest() {
    Library sut = new Library();
    int[][] weeklyMonthTemperatures = {
      {66, 64, 58, 65, 71, 57, 60},
      {57, 65, 65, 70, 72, 65, 51},
      {55, 54, 60, 53, 59, 57, 61},
      {65, 56, 55, 52, 55, 62, 57}
    };
    int[] expectedArray = {55, 54, 60, 53, 59, 57, 61};
    int[] actualOutput = sut.lowestAverage(weeklyMonthTemperatures);

    assertArrayEquals(expectedArray, actualOutput, "Array is {55, 54, 60, 53, 59, 57, 61}");
  }

  @Test
  void testAnalyzeTemps() {
    Library sut = new Library();

    int[][] weeklyMonthTemperatures = {
      {66, 64, 58, 65, 71, 57, 60},
      {57, 65, 65, 70, 72, 65, 51},
      {55, 54, 60, 53, 59, 57, 61},
      {65, 56, 55, 52, 55, 62, 57}
    };
    String expectedReturn =
      """
        High: 72
        Low: 51
        Never saw temperature: 63
        Never saw temperature: 67
        Never saw temperature: 68
        Never saw temperature: 69
        """;
    String actualReturn = sut.analyzeTemps(weeklyMonthTemperatures);

    assertEquals(expectedReturn, actualReturn);
  }

  @Test
  void testTally() {
    Library sut = new Library();

    List<String> votes = new ArrayList<>();
    votes.add("Bush");
    votes.add("Bush");
    votes.add("Bush");
    votes.add("Shrub");
    votes.add("Hedge");
    votes.add("Shrub");
    votes.add("Bush");
    votes.add("Hedge");
    votes.add("Bush");

    String expectedWinner = "Bush";
    String actualWinner = sut.tally(votes);

    assertEquals(expectedWinner, actualWinner, "Bush should be the winner");
  }
}
