
package es.uvigo.esei.aed1.activity3.orderedLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.Node;

public class OrderedLinkedDummy {

  private Node first;

  private int numOfValues;

  public OrderedLinkedDummy() {

    this.first = new Node(-0, null);
    this.numOfValues = 0;

  }

  public boolean contains(int value) {

    if (this.numOfValues == 0) {
      return false;
    }

    Node current = this.first.getNext();

    while (current.getNext() != null && !current.hasValue(value)) {
      current = current.getNext();
    }

    if (current.hasValue(value)) {
      return true;
    }

    return false;
  }

  public void add(int value) {

    Node newNode = new Node(value, null);
    Node previous = this.first;

    Node current = this.first.getNext();

    while (current != null && current.getValue() < value) {
      previous = current;
      current = current.getNext();

    }

    newNode.setNext(current);

    previous.setNext(newNode);
    this.numOfValues++;

  }

  public void remove(int value) {

    if (this.numOfValues == 0) {
      System.out.println("Empty Structure");
      return;
    }

    Node current = this.first.getNext();
    Node previous  =this.first;
    if (this.numOfValues == 1 && current.hasValue(value)) {
      previous.setNext(null);
      this.numOfValues--;

    } else {

      while (current != null && !current.hasValue(value)) {
        previous = current;
        current = current.getNext();
      }

    }

    if (current == null) {
      System.out.println("Value not found");
    } else {

      previous.setNext(current.getNext());

      this.numOfValues--;
    }

  }

  @Override
  public String toString() {
    
    StringBuilder sb = new StringBuilder();

    Node current = this.first.getNext();

    while (current != null) {
      
      sb.append(current.getValue()).append(" ");
      current = current.getNext();
    }
    
    
    return sb.toString();

  }

}
