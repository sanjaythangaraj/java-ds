package ds.queue;

public interface CircularQueue<E> extends Queue<E> {
  void rotate();
}