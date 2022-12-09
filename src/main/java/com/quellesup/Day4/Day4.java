package com.quellesup.Day4;

import com.quellesup.util.InputScanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Day4 {
 static final String INPUT_PATH = "src/main/resources/input-day4.txt";


  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(solutionPart1());
    System.out.println(solutionPart2());
  }

  public static String solutionPart1() throws FileNotFoundException {
    var items = InputScanner.addItemsFromInput(INPUT_PATH);
    int counter = 0;
    for (String item : items) {
      var pair = item.split(",");
      var firstItem = Arrays.stream(pair[0].split("-")).mapToInt(Integer::parseInt).toArray();
      var secondItem = Arrays.stream(pair[1].split("-")).mapToInt(Integer::parseInt).toArray();

      if (isRangeContained(firstItem, secondItem)) counter++;
    }
    return String.valueOf(counter);
  }

  public static String solutionPart2() throws FileNotFoundException {
    var items = InputScanner.addItemsFromInput(INPUT_PATH);
    int counter = 0;
    for (String item : items) {
      var pair = item.split(",");
      var firstItem = Arrays.stream(pair[0].split("-")).mapToInt(Integer::parseInt).toArray();
      var secondItem = Arrays.stream(pair[1].split("-")).mapToInt(Integer::parseInt).toArray();

      if (doesRangeOverlap(firstItem, secondItem)) counter++;
    }
    return String.valueOf(counter);
  }

  private static boolean isRangeContained(int[] firstItem, int[] secondItem) {
    return firstItem[0] <= secondItem[0] && firstItem[1] >= secondItem[1]
      || firstItem[0] >= secondItem[0] && firstItem[1] <= secondItem[1];
  }

  private static boolean doesRangeOverlap(int[] firstItem, int[] secondItem) {
    return firstItem[0] <= secondItem[1] && firstItem[1] >= secondItem[0];
  }

}
