package ds.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
  protected ArrayList<Entry<K, V>> list = new ArrayList<>();

  public HeapPriorityQueue() {
    super();
  }

  public HeapPriorityQueue(Comparator<K> comp) {
    super(comp);
  }

  protected int parent(int j) {
    return (j - 1) / 2;
  }

  protected int left(int j) {
    return 2 * j + 1;
  }

  protected int right(int j) {
    return 2 * j + 2;
  }

  protected boolean hasLeft(int j) {
    return left(j) < list.size();
  }

  protected boolean hasRight(int j) {
    return right(j) < list.size();
  }

  protected void swap(int i, int j) {
    Entry<K, V> temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }

  protected void upheap(int j) {
    while (j > 0) {
      int p = parent(j);
      if (compare(list.get(j), list.get(p)) >= 0)
        break;
      swap(j, p);
      j = p;
    }
  }

  public int size() {
    return list.size();
  }

  public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
    checkKey(key);
    Entry<K, V> entry = new PQEntry<>(key, value);
    list.add(entry);
    upheap(list.size() - 1);
    return entry;
  }

  protected void downheap(int j) {
    while (hasLeft(j)) {
      int leftIndex = left(j);
      int minChildIndex = leftIndex;

      if (hasRight(j)) {
        int rightIndex = right(j);
        if (compare(list.get(leftIndex), list.get(rightIndex)) > 0)
          minChildIndex = rightIndex;
      }

      if (compare(list.get(minChildIndex), list.get(j)) >= 0)
        break;

      swap(j, minChildIndex);
      j = minChildIndex;
    }
  }

  public Entry<K, V> min() {
    if (list.isEmpty())
      return null;
    return list.get(0);
  }

  public Entry<K, V> removeMin() {
    if (list.isEmpty())
      return null;
    Entry<K, V> answer = list.get(0);
    swap(0, list.size() - 1);
    list.remove(list.size() - 1);
    downheap(0);
    return answer;
  }

}