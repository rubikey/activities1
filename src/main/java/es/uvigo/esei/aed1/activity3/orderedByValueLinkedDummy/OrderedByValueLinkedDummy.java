package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.Node;

public class OrderedByValueLinkedDummy {

  private NodePair dummy;
  private int numOfValues;

  public OrderedByValueLinkedDummy() {
    this.dummy = new NodePair(new Pair(1, -1), null);
    this.numOfValues = 0;

  }

  public boolean contains(int value) {

    if (this.numOfValues == 0) {
      return false;

    }

    NodePair current = this.dummy.getNext();
    while (current != null) {

      if (current.getPair().getValue() == value) {
        return true;

      }
      current = current.getNext();
    }

    return false;
  }

  public void add(int value) {

    NodePair current = this.dummy;

    while (current.getNext() != null && current.getNext().getPair().getValue() < value) {
      current = current.getNext();

    }

    if (current.getNext() != null && current.getNext().getPair().getValue() == value) {
      current.getNext().getPair().setCounter(current.getNext().getPair().getCounter() + 1); // Si el valor existe
                                                                                            // incrementamos el counter

    } else {

      NodePair newNodePair = new NodePair(new Pair(value, 1), null);

      current.setNext(newNodePair);

      this.numOfValues++;

    }

  }

  public void remove(int value) {
    NodePair current = this.dummy;

    while (current.getNext() != null && current.getNext().getPair().getValue() != value) {
      current = current.getNext();
    }

    if (current.getNext() == null) {
      System.out.println("The value is not contained");
      return;
    }

    Pair pair = current.getNext().getPair();
    if (pair.getCounter() > 1) {
      // Si hay más de una copia, reducimos el counter
      pair.setCounter(pair.getCounter() - 1);
    } else {
      // Si solo hay una copia, eliminamos el nodo
      current.setNext(current.getNext().getNext());
      this.numOfValues--;
    }
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    NodePair current = this.dummy.getNext();

    while (current != null) {
      sb.append(current.getPair().getValue()).append(" ");
      current = current.getNext();
    }

    return sb.toString();
  }
}
