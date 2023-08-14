package work3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  private static LinkedList<Integer> getIntegerList () {
    int n;

    LinkedList<Integer> list = new LinkedList<>();
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter n:");
      String nstr = scanner.nextLine();
      try {
        n = Integer.parseInt(nstr);
      } catch (NumberFormatException ignored) {
        n = 3;
        System.out.println("n = 3");
      }

      for(int i = 0; i < n; i++) {
        System.out.print("Enter number:");
        String istr = scanner.nextLine();

        try {
          int number = Integer.parseInt(istr);
          list.add(number);
        } catch (NumberFormatException ignored) {
          System.out.println("User Invalid :)");
          i--;
        }
      }
    }

    return list;
  }

  private static <S extends Integer> int getMinimum (LinkedList<S> list) {
    if (list.isEmpty()) {
      throw new RuntimeException("List Invalid :)");
    }

    int n = list.size();
    int min = list.get(0);

    for(int i = 1; i < n; i++) {
      int number = list.get(i);
      if (min > number) {
        min = number;
      }
    }

    return min;
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = getIntegerList();
    int minimum = getMinimum(list);

    System.out.println(minimum);
  }
}
