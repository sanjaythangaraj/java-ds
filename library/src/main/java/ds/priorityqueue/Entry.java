package ds.priorityqueue;

public interface Entry<K, V> {
  K getKey();
  V getValue();
}