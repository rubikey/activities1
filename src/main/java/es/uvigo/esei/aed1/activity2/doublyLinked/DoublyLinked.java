
package es.uvigo.esei.aed1.activity2.doublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;
import es.uvigo.esei.aed1.commonLinked.Node;

public class DoublyLinked {

  private DoubleNode first;
  private DoubleNode last;
  private int numOfValues;

  public DoublyLinked() {
    this.first = null;
    this.last = null;
    this.numOfValues = 0;
  }

  public boolean isEmpty() {

    return this.first == null;
  }

  public int size() {

    return this.numOfValues;
  }

  public int numberOfOccurrences(int value) {

    int number = 0;

    for (DoubleNode current = first; current != null; current = current.getNext()) {
      if (current.hasValue(value)) {
        number++;
      }

    }

    return number;
  }

  public boolean contains(int value) {

    DoubleNode current = first;

    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }

    return current!=null;
  }

  public void addFirst(int value) {

  }

  public void addLast(int value) {

  }

  public void remove(int value) {

  }

  @Override
  public String toString() {

    return "";
  }

}
