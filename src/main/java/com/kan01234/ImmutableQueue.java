package com.kan01234;
public final class ImmutableQueue<T> implements Queue<T> {

  private final Stack<T> order;

  private final Stack<T> reserve;

  public ImmutableQueue(Stack<T> order, Stack<T> reserve) {
    this.order = order;
    this.reserve = reserve;
  }

  public Queue<T> enQueue(T t) {
    return new ImmutableQueue<T>(order, reserve.push(t));
  }

  public Queue<T> deQueue() {
    Stack<T> o = order.pop();
    if (!o.isEmpty())
      return new ImmutableQueue<T>(o, reserve);
    else if (reserve.isEmpty())
      return getEmptyInstance();
    else
      return new ImmutableQueue<T>(reserveStack(reserve).pop(), ImmutableStack.getEmptyInstance());
  }

  public T head() {
    if (isEmpty())
      return null;
    if (order.isEmpty())
      return (T) reserveStack(reserve).head();
    else
      return order.head();
  }

  public boolean isEmpty() {
    return false;
  }

  public final static Queue getEmptyInstance() {
    return EmptyInstance.getInstance();
  }

  private final static Stack reserveStack(Stack stack) {
    Stack reserveStack = ImmutableStack.getEmptyInstance();
    while (!stack.isEmpty()) {
      reserveStack = reserveStack.push(stack.head());
      stack = stack.pop();
    }
    return reserveStack;
  }

  private final static class EmptyInstance<T> implements Queue<T> {

    private final static EmptyInstance emptyInstance = new EmptyInstance();

    public final static EmptyInstance getInstance() {
      return emptyInstance;
    }

    public Queue<T> enQueue(T t) {
      return new ImmutableQueue<T>(ImmutableStack.getEmptyInstance().push(t), ImmutableStack.getEmptyInstance());
    }

    public Queue<T> deQueue() {
      return emptyInstance;
    }

    public T head() {
      return null;
    }

    public boolean isEmpty() {
      return true;
    }

  }

}
