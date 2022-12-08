package com.quellesup.day2;

public enum OpponentShape {

  ROCK("A"), PAPER("B"), SCISSORS("C");
  private String value;
  OpponentShape(String a) {
    this.value = a;
  }

  public String getValue() {
    return value;
  }
}
