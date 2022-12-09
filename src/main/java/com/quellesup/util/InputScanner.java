package com.quellesup.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputScanner {


  public static Scanner getInputFile(String inputPath) throws FileNotFoundException {
    var file = new FileReader(inputPath);
    return new Scanner(file);
  }

  public static List<String> addItemsFromInput(String path) throws FileNotFoundException {
    Scanner sc = InputScanner.getInputFile(path);
    List<String> listOfItems = new ArrayList<>();
    while (sc.hasNextLine()) {
      listOfItems.add(sc.nextLine());
    }
    return listOfItems;
  }
}
