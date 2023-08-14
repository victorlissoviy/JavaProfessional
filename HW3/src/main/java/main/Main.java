package main;

import java.util.*;

public class Main {

  private static Map<String, String> createListFromUser() {
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

  private static void findFamilyByCity(Map<String, String> map) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter city:");
    String city = scanner.nextLine();

    String lastName = map.get(city);

    System.out.println(Objects.requireNonNullElse(lastName, "City Invalid :)"));
  }

  public static void main(String[] args) {
    Map<String, String> map = createListFromUser();
    findFamilyByCity(map);
  }
}
