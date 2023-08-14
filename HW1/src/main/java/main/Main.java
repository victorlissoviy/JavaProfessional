package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();

    Random r = new Random();
    for(int i = 0; i < 10; i++) {
      list.add(r.nextInt());
    }

    Iterator<Integer> iterator = list.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
