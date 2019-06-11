package com.kan01234;

public final class ImmutableQueue<T> implements Queue<T> {

  private final Stack<T> order;

  private final Stack<T> reserve;

  /**
   * Constructor to create ImmutableQueue
   * 
   * @param order data ordered in FIFO
   * @param reserve data ordered reserve in FIFO
   */
  public ImmutableQueue(Stack<T> order, Stack<T> reserve) {
    this.order = order;
    this.reserve = reserve;
  }

  /**
   * @param t data need to added to queue
   * @return return new ImmutableQueue
   **/
  public Queue<T> enQueue(T t) {
    return new ImmutableQueue<T>(order, reserve.push(t));
  }

  /**
   * Method to remove data in Immutable
   * @return return new ImmutableQueue, EmptyInstance if the queue is empty
   */
  public Queue<T> deQueue() {
    if (order.isEmpty()) {
      Stack<T> o = reserveStack(reserve).pop();
      return o.isEmpty() ? getEmptyInstance()
          : new ImmutableQueue<T>(o, ImmutableStack.getEmptyInstance());
    }
    Stack<T> o = order.pop();
    if (o.isEmpty() && reserve.isEmpty())
      return getEmptyInstance();
    else
      return new ImmutableQueue<T>(o, reserve);
  }

  /**
   * get head of the queue
   * @return return head data of the queue
   */
  public T head() {
    if (isEmpty())
      return null;
    if (order.isEmpty())
      return (T) reserveStack(reserve).head();
    else
      return order.head();
  }

  /**
   * check queue is empty or not
   * @return true is empty, otherwise false
   */
  public boolean isEmpty() {
    return false;
  }

  /**
   * get the empty instance
   * @return get a empty instance
   */
  public static final Queue getEmptyInstance() {
    return EmptyInstance.getInstance();
  }

  /**
   * @param stack stack to reserve
   * @return reserved stack
   */
  private static final Stack reserveStack(Stack stack) {
    Stack reserveStack = ImmutableStack.getEmptyInstance();
    while (!stack.isEmpty()) {
      reserveStack = reserveStack.push(stack.head());
      stack = stack.pop();
    }
    return reserveStack;
  }

  private static final class EmptyInstance<T> implements Queue<T> {

    private static final EmptyInstance emptyInstance = new EmptyInstance();

    /**
     * return emptyInstance
     * @return return singleton emptyInstance
     */
    public static final EmptyInstance getInstance() {
      return emptyInstance;
    }

    /**
     * add data to queue
     * @return return new ImmtuableQueue
     */
    public Queue<T> enQueue(T t) {
      return new ImmutableQueue<T>(ImmutableStack.getEmptyInstance().push(t),
          ImmutableStack.getEmptyInstance());
    }

    /**
     * remove data from queue, return empty instance since removing data from empty queue
     * @return emptyInstance
     */
    public Queue<T> deQueue() {
      return emptyInstance;
    }

    /**
     * return first data from queue, return null since get data from empty queue
     * @return null
     */
    public T head() {
      return null;
    }

    /**
     * check queue is empty, always true
     * @return true
     */
    public boolean isEmpty() {
      return true;
    }

  }

}
