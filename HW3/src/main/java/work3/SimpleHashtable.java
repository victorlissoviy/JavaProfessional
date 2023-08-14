package work3;

import java.util.Hashtable;

public class SimpleHashtable<K, V> extends Hashtable<K, V> {
  @Override
  public synchronized V put(K key, V value) {
    return super.put(key, value);
  }

  @Override
  public synchronized V remove(Object key) {
    return super.remove(key);
  }
}
