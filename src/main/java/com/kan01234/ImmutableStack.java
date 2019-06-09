package com.kan01234;

public final class ImmutableStack<T> implements Stack<T> {

  private final T head;

  private final Stack<T> stack;

  public ImmutableStack() {
    head = null;
    stack = null;
  }

  public ImmutableStack(T head, Stack<T> stack) {
    this.head = head;
    this.stack = stack;
  }

  public T head() {
    return head;
  }

  public boolean isEmpty() {
    return head == null && stack == null;
  }

  public final Stack<T> push(T t) {
    return new ImmutableStack<T>(t, this);
  }

  public final Stack<T> pop() {
    return stack;
  }

}
