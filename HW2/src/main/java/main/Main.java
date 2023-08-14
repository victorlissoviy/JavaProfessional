package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  private static <S> List<S> doubleValues(List<S> list) {
    List<S> newList = new ArrayList<>();

    for (S l : list) {
      newList.add(l);
      newList.add(l);
    }

    return newList;
  }
  public static void main(String[] args) {
    final int n = 5;

    List<String> list = new ArrayList<>();
    try (Scanner scanner = new Scanner(System.in)) {
      for (int i = 0; i < n; i++) {
        System.out.print("Enter word:");
        String line = scanner.nextLine();

        list.add(line);
      }
    }

    list = doubleValues(list);

    for (String s : list) {
      System.out.println(s);
    }
  }
}
