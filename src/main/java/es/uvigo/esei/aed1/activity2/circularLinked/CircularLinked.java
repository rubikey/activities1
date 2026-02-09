package es.uvigo.esei.aed1.activity2.circularLinked;

import es.uvigo.esei.aed1.commonLinked.Node;

public class CircularLinked {

  private int numOfValues;
  private Node last;

  public CircularLinked() {
    this.numOfValues = 0;
    this.last = null;

  }

  public boolean isEmpty() {

    return this.last == null;
  }

  public int size() {

    return this.numOfValues;
  }

  public int firstValue() throws NullPointerException {

    if (this.isEmpty()) {
      throw new NullPointerException("Lista vacía");

    }

    return this.last.getNext().getValue();
  }

  public boolean contains(int value) {

    if (this.isEmpty()) {
      return false;
    }

    // Empezamos por el primer nodo
    Node current = this.last.getNext();

    // avanza mientras no se llegue al inicio otra vez, si se encuentra devuelve
    // true, si no, devuelve falso
    do {
      if (current.hasValue(value)) {
        return true;
      }
      current = current.getNext();
    } while (current != this.last.getNext());

    return false;
  }

  public boolean contains2(int value) {

    return true;
  }

  public int numberOfOccurrences(int value) {

    if (this.isEmpty()) {
      return 0;
    }

    Node current = this.last.getNext();

    int numero = 0;

    do {

      if (current.hasValue(value)) {
        numero++;
      }

      current = current.getNext();
    } while (current != this.last.getNext());

    return numero;
  }

  public void addLast(int value) {
    Node newNode = new Node(value, last);

    if (this.isEmpty()) {
      this.last = newNode;
      this.last.setNext(this.last);
    }

    else {
      newNode.setNext(this.last.getNext());
      this.last.setNext(newNode);

    }
    this.numOfValues++;
  }

  public void removeFirst() {
    if (this.isEmpty()) {
      System.out.println("Estructura vacía");
      return;
    }

    if (this.numOfValues == 1) {
      this.last = null;
    } else {

      this.last.setNext(this.last.getNext().getNext());

    }

    this.numOfValues--;

  }

  @Override
  public String toString() {
    if (this.isEmpty()) {
      return "Lista vacía";
    }

    StringBuilder sb = new StringBuilder();
    Node current = this.last.getNext(); // Empezamos en el primero

    do {
      sb.append(current.getValue()).append(" ");
      current = current.getNext(); // Avanzamos DENTRO del bucle
    } while (current != this.last.getNext()); // Paramos al volver al inicio

    return sb.toString().trim();
  }
}
