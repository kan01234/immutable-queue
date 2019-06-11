package com.kan01234;

public final class ImmutableStack<T> implements Stack<T> {

  private final T head;

  private final Stack<T> stack;

  public ImmutableStack(T head, Stack<T> stack) {
    this.head = head;
    this.stack = stack;
  }

  public T head() {
    return head;
  }

  public boolean isEmpty() {
    return false;
  }

  public final Stack<T> push(T t) {
    return new ImmutableStack<T>(t, this);
  }

  public final Stack<T> pop() {
    return stack;
  }

  public static final Stack getEmptyInstance() {
    return EmptyInstance.getInstance();
  }

  private static final class EmptyInstance<T> implements Stack<T> {

    private static final EmptyInstance emptyInstance = new EmptyInstance();

    public static final EmptyInstance getInstance() {
      return emptyInstance;
    }

    public T head() {
      return null;
    }

    public boolean isEmpty() {
      return true;
    }

    public Stack<T> push(T t) {
      return new ImmutableStack(t, emptyInstance);
    }

    public Stack<T> pop() {
      return emptyInstance;
    }

  }

}
