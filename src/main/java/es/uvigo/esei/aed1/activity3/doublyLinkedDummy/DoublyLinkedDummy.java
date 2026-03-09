
package es.uvigo.esei.aed1.activity3.doublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedDummy {

  private DoubleNode first;
  private DoubleNode last;
  private int numOfValues;

  public DoublyLinkedDummy() {
    this.first = new DoubleNode(null, -0, null);
    this.last = new DoubleNode(this.first, -0, null);
    this.first.setNext(this.last);
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

    int toRet = 0;

    DoubleNode current = this.first.getNext();

    while (current != this.last) {
      current = current.getNext();

      if (current.hasValue(value)) {
        toRet++;
      }

    }

    return toRet;
  }

  public boolean contains(int value) {

    if (this.isEmpty()) {
      return false;
    }

    DoubleNode current = this.first.getNext();

    while (current != this.last) {

      if (current.hasValue(value)) {
        return true;
      }

      current = current.getNext();

    }

    return false;
  }

  public void addFirst(int value) {

    DoubleNode newNode = new DoubleNode(this.first, value, this.first.getNext());

    newNode.getNext().setPrevious(newNode);
    newNode.getPrevious().setNext(newNode);

    this.numOfValues++;

  }

  public void addLast(int value) {

    DoubleNode newNode = new DoubleNode(this.last.getPrevious(), value, this.last);

    newNode.getPrevious().setNext(newNode);
    newNode.getNext().setPrevious(newNode);

    this.numOfValues++;

  }

  public void remove(int value) {

    if (this.isEmpty()) {
      System.out.println("Empty Structure");
    }

    DoubleNode current = this.first.getNext();

    if (this.numOfValues == 1 && current.hasValue(value)) {
      this.first.setNext(this.last);
      this.last.setPrevious(this.first);
      this.numOfValues--;
    } else {

      while (current != this.last && !current.hasValue(value)) {

        current = current.getNext();

      }

      if (current.hasValue(value)) {
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
        this.numOfValues--;
      } else {

        System.out.println("Value not found");
      }

    }
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    DoubleNode current = this.first.getNext();

    while (current != this.last) {
      sb.append(current.getValue()).append(" ");
      current = current.getNext();
    }

    return sb.toString();
  }

}
