package ds.queue;

import ds.list.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {
  private SinglyLinkedList<E> list = new SinglyLinkedList<E>();

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  public void enqueue(E e) {
    list.addLast(e);
  }
  
  public E dequeue() {
    return list.removeFirst();
  }
  
  public E first() {
    return list.first();
  }
  
}