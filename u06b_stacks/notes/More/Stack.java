//: c11:StackL.java
// Making a stack from a LinkedList.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.*;

// This class uses a LinkedList to store the items in the stack, rather
// than inheriting from the List interface like the standard Stack does.
public class Stack<T> {
  private LinkedList<T> list = new LinkedList<T>();
  public void push(T v) { list.addFirst(v); }
  public T peak() { return list.getFirst(); }
  public T pop() { return list.removeFirst(); }
  public boolean empty() { return list.isEmpty(); }
  public String toString() { return list.toString(); }
  public int size() { return list.size(); }
} ///:~
