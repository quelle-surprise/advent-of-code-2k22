package com.quellesup.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InputScanner {



  public static Scanner getInputFile(String inputPath) throws FileNotFoundException {
    var file = new FileReader(inputPath);
    return new Scanner(file);
  }
}
