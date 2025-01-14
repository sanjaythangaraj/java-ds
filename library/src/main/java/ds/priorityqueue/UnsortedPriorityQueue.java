package ds.priorityqueue;

import ds.list.*;
import  java.util.Comparator;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
  private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

  public UnsortedPriorityQueue() { super(); }
  public UnsortedPriorityQueue(Comparator<K> comp) { super(comp);}

  private Position<Entry<K, V>> findMin() {
    Position<Entry<K, V>> min = list.first();

    for (Position<Entry<K, V>> walk: list.positions())
      if (compare(walk.getElement(), min.getElement()) < 0)
        min = walk;
    return min;
  }

  public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
    checkKey(key);
    Entry<K, V> entry = new PQEntry<>(key, value);
    list.addLast(entry);
    return entry;
  }

  public Entry<K, V> min() {
    if (list.isEmpty()) return null;
    return findMin().getElement();
  }

  public Entry<K, V> removeMin() {
    if (list.isEmpty()) return null;
    return list.remove(findMin());
  }

  public int size() {return list.size(); }
}