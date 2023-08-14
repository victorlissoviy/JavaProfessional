package work3;

import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Map<String, String> map = new SimpleHashtable<>();

    map.put("1", "2");

    System.out.println(map.get("1"));
  }
}
