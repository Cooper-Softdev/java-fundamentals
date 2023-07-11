package basics;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  public static void main(String[] args) {
    int dogCount = 1;
    System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

    int catCount = 2;
    System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

    int turtleCount = 0;
    System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

    Random random = new Random();
    int n = random.nextInt(3) + 1;
    flipNHeads(n);

    clock();
  }

  public static String pluralize(String word, int number) {
    if (number != 1) {
      return word + "s";
    } else {
      return word;
    }
  }

  public static void flipNHeads(int n) {
    Random random = new Random();
    int flips = 0;
    int headsInARow = 0;

    while (headsInARow < n) {
      double flip = random.nextDouble();
      if (flip < 0.5) {
        System.out.println("tails");
        headsInARow = 0;
      } else {
        System.out.println("heads");
        headsInARow++;
      }
      flips++;
    }
    System.out.println("It took " + flips + " flips to flip " + headsInARow + " heads in a row.");
  }

  public static void clock() {
    String timeCheck = "";
    while (true) {
      LocalDateTime now = LocalDateTime.now();
      String time = now.format(DateTimeFormatter.ofPattern("h:mm:ss a"));

      if (timeCheck != time) {
        System.out.println(time);
        timeCheck = time;
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
