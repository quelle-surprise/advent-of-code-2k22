package com.quellesup.day1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SolutionPartOne {

  public static void main(String[] args) throws FileNotFoundException {
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

  private static Scanner getInputFile() throws FileNotFoundException {
    var file = new FileReader("src/main/resources/input.txt");
    return new Scanner(file);
  }
}