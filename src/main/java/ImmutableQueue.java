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
    Stack<T> o = order.pop();
    if (!o.isEmpty())
      return new ImmutableQueue<T>(o, reserve);
    else if (reserve.isEmpty())
      return getEmptyInstance();
    else
      return new ImmutableQueue<T>(reserveStack(reserve).pop(), new ImmutableStack<T>());
  }

  public T head() {
    if (order.isEmpty())
      return reserveStack(reserve).head();
    else
      return order.head();
  }

  public boolean isEmpty() {
    return false;
  }

  public final static Queue getEmptyInstance() {
    return EmptyInstance.getInstance();
  }

  private final Stack<T> reserveStack(Stack<T> stack) {
    Stack<T> reserveStack = new ImmutableStack<T>();
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
      return new ImmutableQueue<T>(new ImmutableStack<T>().push(t), new ImmutableStack<T>());
    }

    @SuppressWarnings("unchecked")
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
