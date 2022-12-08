package com.quellesup.day1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(getElfsWith3HighestCaloriesInBackpack(parseAllElfsCalories()));
    System.out.println(getElfWithHighestCaloriesInBackpack(parseAllElfsCalories()));
  }

  public static List<Integer> parseAllElfsCalories() throws FileNotFoundException {
    Scanner sc = getInputFile();
    List<Integer> solution = new ArrayList<>();
    String line;
    int calories = 0;
    while (sc.hasNextLine()) {
      if (!(line = sc.nextLine()).equals("")) {
        calories += Integer.parseInt(line);
      } else {
        solution.add(calories);
        calories = 0;
      }
    }
    return solution;
  }

  public static Integer getElfWithHighestCaloriesInBackpack(List<Integer> elfCalories) {
    return elfCalories.stream()
        .mapToInt(v -> v)
        .max()
        .orElseThrow(NoSuchElementException::new);
  }

  public static Integer getElfsWith3HighestCaloriesInBackpack(List<Integer> elfCalories) {
    return elfCalories.stream()
        .sorted(Collections.reverseOrder())
        .collect(Collectors.toList())
        .stream()
        .limit(3)
        .mapToInt(v -> v)
        .sum();
  }

  private static Scanner getInputFile() throws FileNotFoundException {
    var file = new FileReader("src/main/resources/input-day1.txt");
    return new Scanner(file);
  }
}