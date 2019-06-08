public final class ImmutableQueue<T> implements Queue<T> {

  private final Stack<T> order;

  private final Stack<T> reserve;

  public ImmutableQueue() {
    order = new ImmutableStack<T>();
    reserve = new ImmutableStack<T>();
  }

  public ImmutableQueue(Stack<T> order, Stack<T> reserve) {
    this.order = order;
    this.reserve = reserve;
  }

  public Queue<T> enQueue(T t) {
    return new ImmutableQueue<T>(order, reserve.push(t));
  }

  public Queue<T> deQueue() {
    if (this.isEmpty())
      return new ImmutableQueue<T>();
    if (!order.isEmpty())
      return new ImmutableQueue<T>(order.pop(), reserve);
    else
      return new ImmutableQueue<T>(reserveStack(reserve), new ImmutableStack<T>()).deQueue();
  }

  public T head() {
    if (this.isEmpty())
      return null;
    if (order.isEmpty())
      return reserveStack(reserve).head();
    else
      return order.head();
  }

  public boolean isEmpty() {
    return order.isEmpty() && reserve.isEmpty();
  }

  private final Stack<T> reserveStack(Stack<T> stack) {
    Stack<T> reserveStack = new ImmutableStack<T>();
    while (!stack.isEmpty()) {
      reserveStack = reserveStack.push(stack.head());
      stack = stack.pop();
    }
    return reserveStack;
  }

}
