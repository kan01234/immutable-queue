
public final class ImmutableQueue<T> implements Queue<T> {

  private final Stack<T> stack;

  public ImmutableQueue() {
    stack = new ImmutableStack<T>();
  }

  public ImmutableQueue(Stack<T> stack) {
    this.stack = stack;
  }

  public Queue<T> enQueue(T t) {
    return new ImmutableQueue<T>(stack.push(t));
  }

  public Queue<T> deQueue() {
    return new ImmutableQueue<T>(reserveStack(reserveStack(stack).pop()));
  }

  public T head() {
    return (T) reserveStack(stack).head();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
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
