# immutable-queue
Implementation of immutable queue with the following api
``` Java
public interface Queue<T> {
    public Queue<T> enQueue(T t);
    #Removes the element at the beginning of the immutable queue, and returns the new queue.
    public Queue<T> deQueue();
    public T head();
    public boolean isEmpty();
}
```
### Quick start
to run the test cases
```bash
mvn test
```
