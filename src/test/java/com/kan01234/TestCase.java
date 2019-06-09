package com.kan01234;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class TestCase {

  @Test
  public void testStack() {
    Stack<String> s = ImmutableStack.getEmptyInstance();
    assertEquals(s.isEmpty(), true);
    assertEquals(s.head(), null);
    assertEquals(s.pop(), ImmutableStack.getEmptyInstance());
    s = s.push("1");
    s = s.push("2");
    s = s.push("3");
    assertEquals(s.head(), "3");
    assertEquals(s.isEmpty(), false);
    assertNotEquals(s, ImmutableStack.getEmptyInstance());
    s = s.pop();
    assertEquals(s.head(), "2");
    assertEquals(s.isEmpty(), false);
    assertNotEquals(s, ImmutableStack.getEmptyInstance());
    s = s.pop();
    assertEquals(s.head(), "1");
    assertEquals(s.isEmpty(), false);
    assertNotEquals(s, ImmutableStack.getEmptyInstance());
    s = s.pop();
    assertEquals(s.head(), null);
    assertEquals(s.isEmpty(), true);
    assertEquals(s.pop(), ImmutableStack.getEmptyInstance());
    s = s.push("4");
    s = s.push("5");
    assertEquals(s.head(), "5");
    assertEquals(s.isEmpty(), false);
    assertNotEquals(s, ImmutableStack.getEmptyInstance());
    s = s.pop();
    assertEquals(s.head(), "4");
    assertEquals(s.isEmpty(), false);
    assertNotEquals(s, ImmutableStack.getEmptyInstance());
    s = s.pop();
    assertEquals(s.head(), null);
    assertEquals(s.isEmpty(), true);
    assertEquals(s.pop(), ImmutableStack.getEmptyInstance());
    s = s.push("6");
    s = s.push("7");
    s = s.pop();
    s = s.pop();
    assertEquals(s.head(), null);
    assertEquals(s.isEmpty(), true);
    assertEquals(s.pop(), ImmutableStack.getEmptyInstance());
  }

  @Test
  public void testQueue() {
    Queue<String> q = ImmutableQueue.getEmptyInstance();
    assertEquals(q.isEmpty(), true);
    assertEquals(q.deQueue(), ImmutableQueue.getEmptyInstance());
    assertEquals(q.head(), null);
    q = q.enQueue("1");
    q = q.enQueue("2");
    q = q.enQueue("3");
    assertEquals(q.isEmpty(), false);
    assertEquals(q.head(), "1");
    assertNotEquals(q, ImmutableQueue.getEmptyInstance());
    q = q.deQueue();
    assertEquals(q.isEmpty(), false);
    assertEquals(q.head(), "2");
    assertNotEquals(q, ImmutableQueue.getEmptyInstance());
    q = q.deQueue();
    assertEquals(q.isEmpty(), false);
    assertEquals(q.head(), "3");
    assertNotEquals(q, ImmutableQueue.getEmptyInstance());
    q = q.deQueue();
    assertEquals(q.isEmpty(), true);
    assertEquals(q.head(), null);
    assertEquals(q, ImmutableQueue.getEmptyInstance());
    q = q.enQueue("4");
    q = q.enQueue("5");
    assertEquals(q.isEmpty(), false);
    assertEquals(q.head(), "4");
    assertNotEquals(q, ImmutableQueue.getEmptyInstance());
    q = q.deQueue();
    assertEquals(q.isEmpty(), false);
    assertEquals(q.head(), "5");
    assertNotEquals(q, ImmutableQueue.getEmptyInstance());
    q = q.deQueue();
    assertEquals(q.isEmpty(), true);
    assertEquals(q.head(), null);
    assertEquals(q, ImmutableQueue.getEmptyInstance());
    q = q.enQueue("6");
    q = q.enQueue("7");
    q = q.deQueue();
    q = q.deQueue();
    assertEquals(q.isEmpty(), true);
    assertEquals(q.head(), null);
    assertEquals(q, ImmutableQueue.getEmptyInstance());
  }

}
