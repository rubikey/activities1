
package es.uvigo.esei.aed1.activity2.circularDoublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinked {

  private DoubleNode last;
  private int numOfValues;

  public CircularDoublyLinked() {

    this.last = null;
    this.numOfValues = 0;

  }

  public boolean isEmpty() {
    return this.numOfValues == 0;
  }

  public int size() {
    return this.numOfValues;
  }

  public int numberOfOccurrences(int value) {

    if (this.isEmpty()) {
      return 0;
    }

    int times = 0;
    DoubleNode current = this.last.getNext();
    
    do {
      if (current.hasValue(value)) {
        times++;
      }
      current = current.getNext();
    } while (current != this.last.getNext());

    return times;
  }

  public boolean contains(int value) {

    if (this.isEmpty()) {
      return false;
    }

    for (DoubleNode current = this.last.getNext(); current != this.last.getNext(); current = current.getNext()) {

      if (current.hasValue(value)) {
        return true;
      }
    }

    return false;
  }

  public int firstValue() throws NullPointerException {

    if (this.isEmpty()) {
      throw new NullPointerException("Empty Structure");
    }

    return this.last.getNext().getValue();
  }

  public void addLast(int value) {
    DoubleNode newDoubleNode = new DoubleNode(null, value, null);
    if (this.last == null) {
      // Si la estructura está vacía, next del nodo apunta a el mismo, y previous
      // tambien
      // La referencia last es igual al nuevo nodo
      newDoubleNode.setNext(newDoubleNode);
      newDoubleNode.setPrevious(newDoubleNode);

    } else {

      newDoubleNode.setNext(this.last.getNext());
      newDoubleNode.setPrevious(this.last);
      this.last.getNext().setPrevious(newDoubleNode);
      this.last.setNext(newDoubleNode);

    }

    this.last = newDoubleNode;
    this.numOfValues++;

  }

  public void removeFirst() {

    if (this.numOfValues == 0) {
      System.out.println("Empty Structure");
      return;

    } else if (this.numOfValues == 1) {
      this.last = null;
    } else {

      DoubleNode currentFirst = this.last.getNext();

      DoubleNode newFirst = currentFirst.getNext();

      this.last.setNext(newFirst);
      newFirst.setPrevious(this.last);

    }
    this.numOfValues--;

  }

  public void remove(int value) {

    if (this.numOfValues == 0) {
      System.out.println("Empty Structure");
      return;

    }
    DoubleNode current = this.last.getNext(); // Primero
    boolean found = false;

    // recorremos lista
    // si encontramos el valor, salimos del bucle
    for (int i = 0; i < numOfValues; i++) {
      if (current.getValue() == value) {
        found = true;
        break;
      }
      current = current.getNext();
    }

    // si salimos del bucle, puede ser porque no encontramos el valor

    if (!found) {
      System.out.println("Value not found");
      return;

      // si lo encontramos se elimina
      // el previo a current apunta al siguiente de current
      // el siguiente de current, apunta con su puntero previous al anterior de
      // current
    } else {

      current.getPrevious().setNext(current.getNext());
      current.getNext().setPrevious(current.getPrevious());

      // al eliminar, si current era igual a last, ahora last es el previo de current
      if (current == this.last) {
        this.last = current.getPrevious();

      }
    }

    this.numOfValues--;

  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    DoubleNode current = this.last.getNext();

    for (int i = 0; i < numOfValues; i++) {
      sb.append(current.getValue()).append(" ");
      current = current.getNext();
    }

    return sb.toString();
  }
}
