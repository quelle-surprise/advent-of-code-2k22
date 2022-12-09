package com.quellesup.day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2 {

  public static final int DRAW = 3;
  public static final int WIN = 6;

  // X - LOSE - ROCK
  // Y - DRAW - PAPER
  // Z - WIN - SCISSORS
  private static int calculatePoints(String elfMove, String opponentMove) {
    int skirmishResult = 0;
    skirmishResult = addDefaultPointForMove(elfMove, skirmishResult);
    if (isResultDraw(elfMove, opponentMove)) {
      skirmishResult += DRAW;
    } else if (isResultWin(elfMove, opponentMove)) {
      skirmishResult += WIN;
    }
    return skirmishResult;
  }

  private static int addDefaultPointForMove(String elfMove, int skirmishResult) {
    switch (elfMove) {
      case "X" -> skirmishResult += 1;
      case "Y" -> skirmishResult += 2;
      case "Z" -> skirmishResult += 3;
    }
    return skirmishResult;
  }

  public static int calculateSolution() throws FileNotFoundException {
    Scanner sc = getInputFile();
    int result = 0;
    int result2 = 0;
    String[] lines;
    String elfMove;
    String opponentMove;
    while (sc.hasNextLine()) {
      lines = sc.nextLine().split(" ");
      opponentMove = lines[0];
      elfMove = lines[1];
      result += calculatePoints(elfMove, opponentMove);
      result2 += calculatePoints(replaceElfMove(elfMove, opponentMove), opponentMove);
    }
    return result2;
  }

  private static boolean isResultWin(String elfMove, String opponentMove) {
    return elfMove.equals(ElfShape.ROCK.getValue()) && opponentMove.equals(OpponentShape.SCISSORS.getValue())
        || (elfMove.equals(ElfShape.SCISSORS.getValue()) && opponentMove.equals(OpponentShape.PAPER.getValue())
        || (elfMove.equals(ElfShape.PAPER.getValue()) && opponentMove.equals(OpponentShape.ROCK.getValue())));
  }

  private static boolean isResultDraw(String elfMove, String opponentMove) {
    return elfMove.equals(ElfShape.ROCK.getValue()) && opponentMove.equals(OpponentShape.ROCK.getValue())
        || (elfMove.equals(ElfShape.SCISSORS.getValue()) && opponentMove.equals(OpponentShape.SCISSORS.getValue())
        || (elfMove.equals(ElfShape.PAPER.getValue()) && opponentMove.equals(OpponentShape.PAPER.getValue())));
  }

  private static String replaceElfMove(String elfMove, String opponentMove) {
    String replacedElfMove = null;
    switch (elfMove) {
      case "X" -> {
        if (opponentMove.equals(OpponentShape.SCISSORS.getValue())) {
          replacedElfMove = ElfShape.PAPER.getValue();
        } else if (opponentMove.equals(OpponentShape.ROCK.getValue())) {
          replacedElfMove = ElfShape.SCISSORS.getValue();
        } else if(opponentMove.equals(OpponentShape.PAPER.getValue())) {
          replacedElfMove = ElfShape.ROCK.getValue();
        }
      }
      case "Y" -> {
        if (opponentMove.equals(OpponentShape.SCISSORS.getValue())) {
          replacedElfMove = ElfShape.SCISSORS.getValue();
        } else if (opponentMove.equals(OpponentShape.ROCK.getValue())) {
          replacedElfMove = ElfShape.ROCK.getValue();
        } else if(opponentMove.equals(OpponentShape.PAPER.getValue())) {
          replacedElfMove = ElfShape.PAPER.getValue();
        }
      }
      case "Z" -> {
        if (opponentMove.equals(OpponentShape.SCISSORS.getValue())) {
          replacedElfMove = ElfShape.ROCK.getValue();
        } else if (opponentMove.equals(OpponentShape.ROCK.getValue())) {
          replacedElfMove = ElfShape.PAPER.getValue();
        } else if(opponentMove.equals(OpponentShape.PAPER.getValue())) {
          replacedElfMove = ElfShape.SCISSORS.getValue();
        }
      }
    }
    return replacedElfMove;
  }

  private static Scanner getInputFile() throws FileNotFoundException {
    var file = new FileReader("src/main/resources/input-day2.txt");
    return new Scanner(file);
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(calculateSolution());
  }

}

