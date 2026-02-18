
package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedCentre {

  private DoubleNode center;
  private int numNodesRight, numNodesLeft;

  public DoublyLinkedCentre() {
    this.center = null;
    this.numNodesRight = 0;
    this.numNodesLeft = 0;

  }

  public boolean isEmpty() {

    return this.center == null;
  }

  public int size() {
    if (this.isEmpty()) {
      return 0;
    } else {
      return this.numNodesLeft + numNodesRight;
    }

  }

  public boolean contains(int value) {

    if (this.isEmpty()) {
      return false;
    }

    if (center.hasValue(value)) {
      return true;
    } else {
      DoubleNode current = this.center;

      if (current.getValue() > value) { // menores center
        while (current != null && !current.hasValue(value)) {
          current.getPrevious();
        }

      } else {
        while (current != null && !current.hasValue(value)) {
          current = current.getNext();
        }

      }

      if (current == null) {
        return false;
      } else {
        return current.hasValue(value);
      }

    }

  }

  public void add(int value) {

    DoubleNode newDoubleNode;

    if (this.isEmpty()) {
      newDoubleNode = new DoubleNode(null, value, null);
      this.center = newDoubleNode;
      return;
    }

    DoubleNode current;

    if (value < this.center.getValue()) {
      current = center;

      while (current.getPrevious() != null && value < current.getValue()) {
        current = current.getPrevious();
      }
      // caso que sea el más pequeño
      if (value < current.getValue()) {
        newDoubleNode = new DoubleNode(null, value, current);
        current.setPrevious(newDoubleNode);
      } else {
        newDoubleNode = new DoubleNode(current, value, current.getNext());

        if (current.getNext() != null) {
          current.getNext().setPrevious(newDoubleNode);
        }
        current.setNext(newDoubleNode);

      }

      this.numNodesLeft++;
      // Caso value sea mayor a center, hay que avanzar a la derecha

    } else {
      current = center;

      while (current.getNext() != null && value > current.getValue()) {
        current = current.getNext();
      }

      // caso que sea el valor más alto
      if (value > current.getValue()) {
        newDoubleNode = new DoubleNode(current, value, null);
        current.setNext(newDoubleNode);
      } else {

        newDoubleNode = new DoubleNode(current.getPrevious(), value, current);

        if (current.getPrevious() != null) {
          current.getPrevious().setNext(newDoubleNode);
        }

        current.setPrevious(newDoubleNode);
      }

      this.numNodesRight++;
    }

  }

  @Override
  public String toString() {
    if (this.center == null)
      return "[]";

    StringBuilder sb = new StringBuilder();

    DoubleNode current = this.center;

    // vamos al inicio
    for (int i = 0; i < numNodesLeft; i++) {
      current = current.getPrevious();
    }

    int totalNodes = numNodesLeft + 1 + numNodesRight;

    for (int i = 0; i < totalNodes; i++) {
      sb.append(current.getValue()).append(" ");
      current = current.getNext();
    }
    return sb.toString();
  }

}
