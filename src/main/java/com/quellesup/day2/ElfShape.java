package com.quellesup.day2;

public enum ElfShape {

  ROCK("X"), PAPER("Y"), SCISSORS("Z");
  private String value;
  ElfShape(String a) {
    this.value = a;
  }
  public String getValue() {
    return value;
  }
}
