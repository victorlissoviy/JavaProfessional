package main;

import java.lang.ref.WeakReference;

public class Main {
  public static void main(String[] args) {
    WeakReference<Integer> testInt = new WeakReference<>(1);
    System.out.println(testInt.get());

    System.runFinalization();
    System.gc();
    System.gc();

    System.out.println(testInt.get());
  }
}
