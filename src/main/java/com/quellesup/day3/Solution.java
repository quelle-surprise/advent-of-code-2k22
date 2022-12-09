package com.quellesup.day3;

import com.quellesup.util.InputScanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  public static final String INPUT_PATH = "src/main/resources/input-day3.txt";

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(solutionPart1());
    System.out.println(solutionPart2());
  }

  private static int solutionPart1() throws FileNotFoundException {
    return calculateSumForItems();
  }

  private static int solutionPart2() throws FileNotFoundException {
    return calculateSolutionPart2();
  }

  private static int calculateSumForItems() throws FileNotFoundException {
    List<String> listOfComparedItems = new ArrayList<>();
    getListOfItemsFromRucksackPart1().forEach(
        p -> listOfComparedItems.add(compareItemsInCompartments(p)));
    return listOfComparedItems.stream().mapToInt(Solution::getPriority).sum();
  }

  private static String compareItemsInCompartments(String[] p) {
    String firstElement = p[0];
    String secondElement = p[1];
    return compareTwoRucksacks(firstElement, secondElement)
        .stream()
        .findFirst()
        .get()
        .toString();
  }

  private static Set<Character> compareTwoRucksacks(String firstElement, String secondElement) {
    Set<Character> characterSetInFirstElement = IntStream.range(0, firstElement.length())
        .mapToObj(firstElement::charAt)
        .collect(Collectors.toCollection(TreeSet::new));
    Set<Character> characterSetInSecondElement = IntStream.range(0, secondElement.length())
        .mapToObj(secondElement::charAt)
        .collect(Collectors.toCollection(TreeSet::new));
    characterSetInFirstElement.retainAll(characterSetInSecondElement);
    return characterSetInFirstElement;
  }

  private static int getPriority(String s) {
    return s.chars().map(i -> i >= 'a' && i <= 'z' ? i - 'a' + 1 : i - 'A' + 1 + 26).sum();
  }

  public static List<String[]> getListOfItemsFromRucksackPart1() throws FileNotFoundException {
    List<String> listOfItems = addItemsFromInput();
    return listOfItems.stream().map(String::trim)
        .map(e -> new String[]{e.substring(0, e.length() / 2), e.substring(e.length() / 2)})
        .collect(Collectors.toList());
  }

  public static int calculateSolutionPart2() throws FileNotFoundException {
    var rucksack = new LinkedList<>(addItemsFromInput());
    String[] els = new String[3];
    int sum = 0;
    while (!rucksack.isEmpty()) {
      els[0] = rucksack.poll();
      els[1] = rucksack.poll();
      els[2] = rucksack.poll();
      sum += compareThreeRucksacksAndReturnSum(els);
    }
    return sum;
  }

  private static List<String> addItemsFromInput() throws FileNotFoundException {
    Scanner sc = InputScanner.getInputFile(INPUT_PATH);
    List<String> listOfItems = new ArrayList<>();
    while (sc.hasNextLine()) {
      listOfItems.add(sc.nextLine());
    }
    return listOfItems;
  }

  private static int compareThreeRucksacksAndReturnSum(String[] p) {
    var firstElement = p[0].chars().mapToObj(e-> (char) e).collect(Collectors.toList());
    var secondElement = p[1].chars().mapToObj(e-> (char) e).collect(Collectors.toList());
    var thirdElement = p[2].chars().mapToObj(e-> (char) e).collect(Collectors.toList());
    return firstElement.stream()
        .filter(secondElement::contains)
        .filter(thirdElement::contains)
        .mapToInt(Solution::charValue)
        .findAny()
        .getAsInt();
  }

  private static int charValue(char c) {
    return c >= 97 ? c - 96 : c - 38;
  }

}
