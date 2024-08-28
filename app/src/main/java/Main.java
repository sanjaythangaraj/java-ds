import ds.stack.*;
import ds.queue.*;
import ds.list.*;
import ds.priorityqueue.*;

import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    runPriorityQueue();
  }

  private static void runPriorityQueue() {
    PriorityQueue<String, Integer> queue = new HeapPriorityQueue<>();
    queue.insert("Apple", 12);
    queue.insert("Orange", 6);
    queue.insert("BlueBerry", 9);
    queue.insert("Pineapple", 10);

    while (!queue.isEmpty()) {
      Entry<String, Integer> entry = queue.removeMin();
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }

  private static void runPositionalList() {
    LinkedPositionalList<String> list = new LinkedPositionalList<String>();
    list.addLast("Orange");
    Position<String> p2 = list.addFirst("Grape");
    Position<String> p1 = list.addFirst("Watermelon");
    list.addAfter(p2, "Pineapple");
    Position<String> p0 = list.addBefore(p1, "Apple");

    for (String s : list.elements())
      System.out.println(s);
  }

  private static void runArrayList() {
    ArrayList<Integer> list = new ArrayList<Integer>(3);
    list.add(0, 1);
    list.add(0, 0);
    list.add(2, 3);
    list.set(2, 2);
    list.add(0, -1);
    list.add(4, 3);
    while (!list.isEmpty()) {
      System.out.println(list.get(list.size() - 1));
      System.out.println(list.remove(list.size() - 1));
    }

    list.add(0, 1);
    list.add(0, 0);
    list.add(2, 3);
    list.set(2, 2);
    list.add(0, -1);
    list.add(4, 3);

    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      iterator.remove();
    }
    System.out.println(list.isEmpty());

  }

  private static void runDeque() {
    Deque<Character> deque = new DoublyLinkedQueue<Character>();
    deque.addLast('Z');
    deque.addFirst('B');
    deque.addFirst('A');
    while (!deque.isEmpty())
      System.out.println(deque.removeFirst());
    deque.addLast('W');
    System.out.println(deque.last());
    System.out.println(deque.first());
  }

  private static void runStack() {
    Stack<Integer> stack = new LinkedStack<Integer>();
    stack.push(5);
    stack.push(3);
    System.out.println(stack.size());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
    System.out.println(stack.top());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
    System.out.println(stack.pop());
  }

  private static void runQueue() {
    Queue<Integer> queue = new LinkedQueue<Integer>();
    queue.enqueue(1);
    queue.enqueue(2);
    System.out.println(queue.size());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.isEmpty());
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.isEmpty());
  }

}