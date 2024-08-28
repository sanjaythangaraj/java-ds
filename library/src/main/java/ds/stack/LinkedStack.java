package ds.stack;

import ds.list.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

  private SinglyLinkedList<E> list = new SinglyLinkedList<E>();
  
  public int size() {
    return list.size();
  }
  
  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  public E top() {
    return list.first();
  }
  
  public E pop() {
    return list.removeFirst();
  }
  
  public void push(E e) {
    list.addFirst(e);
  }
  
}