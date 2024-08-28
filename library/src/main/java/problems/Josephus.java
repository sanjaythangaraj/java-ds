package problems;

import ds.queue.*;

public class Josephus {
  public static <E> CircularQueue<E> buildQueue(E[] arr) {
    CircularQueue<E> queue = new LinkedCircularQueue<E>();
    for (E e: arr) {
      queue.enqueue(e);
    }
    return queue;
  }

  public static <E> E Josephus(CircularQueue<E> queue, int k) {
    if (queue.isEmpty()) return null;
    while (queue.size() >  1) {
      for (int i = 0; i < k-1; i++)
        queue.rotate();
      E e = queue.dequeue();
      System.out.println("  " + e + " is out");
    }
    return queue.dequeue();
  }

  public static void main(String[] args) {
    String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
    String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
    String[] a3 = {"Mike", "Roberto"};
    System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
    System.out.println("First winner is " + Josephus(buildQueue(a2), 10));
    System.out.println("First winner is " + Josephus(buildQueue(a3), 7));
  }
}