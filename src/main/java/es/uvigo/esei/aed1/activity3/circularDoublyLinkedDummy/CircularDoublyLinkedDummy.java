
package es.uvigo.esei.aed1.activity3.circularDoublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinkedDummy {

  private DoubleNode last;
  private int numOfValues;

  public CircularDoublyLinkedDummy() {
    this.last = new DoubleNode(null, -0, null);
    this.last.setNext(this.last);
    this.last.setPrevious(this.last);

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

    DoubleNode current = this.last.getNext();

    int toret = 0;

    while (current != this.last) {
      if (current.hasValue(value)) {
        toret++;
      }
      current = current.getNext();

    }

    return toret;
  }

  public boolean contains(int value) {

    DoubleNode current = this.last.getNext();

    while (current != this.last && !current.hasValue(value)) {
      current = current.getNext();
    }

    if (current.hasValue(value)) {
      return true;
    }

    return false;
  }

  public void addFirst(int value) {

    DoubleNode newNode;

    if (this.isEmpty()) {

      newNode = new DoubleNode(this.last, value, this.last);
      this.last.setPrevious(newNode);
      this.last.setNext(newNode);

      this.numOfValues++;

    }

    newNode = new DoubleNode(this.last, value, this.last.getNext());

    this.last.getNext().setPrevious(newNode);
    this.last.setNext(newNode);

    this.numOfValues++;

  }

  public void addLast(int value) {

    DoubleNode newNode;

    if (isEmpty()) {

      newNode = new DoubleNode(this.last, value, this.last);
      this.last.setPrevious(newNode);
      this.last.setNext(newNode);

      this.numOfValues++;

    }

    newNode = new DoubleNode(this.last.getPrevious(), value, this.last);

    this.last.getPrevious().setNext(newNode);
    this.last.setPrevious(newNode);

    this.numOfValues++;

  }

  public void remove(int value) {

    if (this.isEmpty()) {
      System.out.println("Empty Structure");

    }

    DoubleNode current = this.last.getNext();

    if (this.numOfValues == 1 && current.hasValue(value)) {
      this.last.setNext(this.last);
      this.last.setPrevious(this.last);
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

        System.out.println("Value is not contained");
      }

    }

  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    DoubleNode current = this.last.getNext();

    while (current != this.last) {

      sb.append(current.getValue()).append(" ");
      current = current.getNext();

    }

    return sb.toString();
  }

}
