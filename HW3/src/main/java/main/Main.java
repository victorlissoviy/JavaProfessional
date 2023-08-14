package main;

import java.util.AbstractMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

  private static AbstractMap<String, String> createListFromUser() {
    int n;
    TreeMap<String, String> map = new TreeMap<>();

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter n:");
    String nstr = scanner.nextLine();

    try {
      n = Integer.parseInt(nstr);
    } catch (NumberFormatException ignored) {
      n = 3;
      System.out.println("n = 3");
    }

    for (int i = 0; i < n; i++) {
      System.out.print("Enter city:");
      String city = scanner.nextLine();

      System.out.print("Enter last name:");
      String lastName = scanner.nextLine();

      map.put(city, lastName);
    }

    return map;
  }

  private static void findFamilyByCity(AbstractMap<String, String> map) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter city:");
    String city = scanner.nextLine();

    String lastName = map.get(city);

    System.out.println(Objects.requireNonNullElse(lastName, "City Invalid :)"));
  }

  public static void main(String[] args) {
    AbstractMap<String, String> map = createListFromUser();
    findFamilyByCity(map);
  }
}
