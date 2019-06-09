package com.kan01234;

public interface Stack<T> {

  public T head();

  public boolean isEmpty();

  public Stack<T> push(T t);

  public Stack<T> pop();

}
