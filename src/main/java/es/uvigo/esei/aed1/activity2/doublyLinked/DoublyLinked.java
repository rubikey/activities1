
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

    return current != null;
  }

  public void addFirst(int value) {

    DoubleNode newDoubleNode = new DoubleNode(null, value, this.first);
    if (this.isEmpty()) {

      this.first = newDoubleNode;
      this.last = newDoubleNode;

    } else {
      this.first.setPrevious(newDoubleNode);
      this.first = newDoubleNode;

    }

    this.numOfValues++;

  }

  public void addLast(int value) {
    DoubleNode newDoubleNode = new DoubleNode(this.last, value, null);

    if (this.isEmpty()) {
      this.first = newDoubleNode;
      this.last = newDoubleNode;

    } else {
      this.last.setNext(newDoubleNode);
      newDoubleNode.setPrevious(last);
      this.last = newDoubleNode;
    }

    this.numOfValues++;

  }

  public void remove(int value) {
    if (this.isEmpty()) {
      System.out.println("Estructura Vacía");
      return;
    }

    // Caso si el valor a eliminar es el primero
    if (this.first.hasValue(value)) {
      this.first = this.first.getNext();
      // se cambia la referencia first

      // si al eliminar el primero, no queda vacía, la referencia de previous de first
      // es null
      if (this.first != null) {
        this.first.setPrevious(null);

        // Si queda la estructura vacía, last es igual a null
      } else {
        this.last = null;

      }
      this.numOfValues--;
      return;

    }


    // Caso buscar en el resto de la lista

    DoubleNode current = this.first;
    // Mientras current no sea null, y no aparezca el valor a eliminar, seguimos
    // buscando
    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }

    // Una vez fuera del bucle, comprobamos

    // No se ha encontrado

    if (current == null) {
      System.out.println("Valor no encontrado");
      return;
    }

    // Caso valor en el último nodo (last)
    if (current == this.last) {

      this.last = this.last.getPrevious();
      this.last.setNext(null);

    // Caso nodo en cualquier otro sitio de la estructura
    } else {

      current.getPrevious().setNext(current.getNext());
      current.getNext().setPrevious(current.getPrevious());
    }

    this.numOfValues--;

  }

  @Override
  public String toString() {
    StringBuilder cadena = new StringBuilder();

    DoubleNode current = this.first;

    while (current != null) {
      cadena.append(current.getValue()).append(" ");
      current = current.getNext();
    }

    return cadena.toString();
  }

}
