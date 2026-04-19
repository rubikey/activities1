
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.requireNonNull;

public class LinkedQueue2Ref<T> implements CustomQueue<T> {

  private Node<T> first, last;
  private int numOfValues;

  public LinkedQueue2Ref() {
    this.first = null;
    this.last = null;
    this.numOfValues = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.numOfValues == 0;
  }

  @Override
  public int size() {
    return this.numOfValues;
  }

  @Override
  public T first() throws EmptyException {

    if (this.isEmpty()) {
      throw new EmptyException("Empty");
    }

    return this.first.getValue();
  }

  @Override
  public void add(T value) throws NullPointerException {
    if (value == null) {
      throw new NullPointerException("No se pueden añadir valores nulos");
    }

    Node<T> newNode = new Node<>(value, null);

    if (isEmpty()) {
      this.first = newNode;
    } else {
      this.last.setNext(newNode);
    }

    this.last = newNode;
    this.numOfValues++;

  }

  @Override
  public T remove() throws EmptyException {
    if (this.isEmpty()) {
      throw new EmptyException("La cola está vacía");
    }

    T value = this.first.getValue(); // 1. Guardamos el valor
    this.first = this.first.getNext(); // 2. El frente ahora es el siguiente

    // 3. Caso especial: si la cola se ha quedado vacía
    if (this.first == null) {
      this.last = null;
    }

    this.numOfValues--; // 4. Decrementamos el contador
    return value;
  }

  @Override
  public void clear() {
    this.first = null;
    this.last = null;
    this.numOfValues = 0;
  }

}
