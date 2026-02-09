package es.uvigo.esei.aed1.activity2.linkedWith2References;

import es.uvigo.esei.aed1.commonLinked.Node;

public class LinkedWith2References {

  private Node first;
  private Node last;
  private int numOfValues;

  // Constructor
  public LinkedWith2References() {
    this.first = null;
    this.last = null;
    this.numOfValues = 0;

  }

  // Comprobar si la estructura está vacía
  public boolean isEmpty() {

    return this.first == null;
  }

  // Tamaño de la estructura
  public int size() {

    return this.numOfValues;
  }

  // Contar el número de veces que aparece un elemento en la estructura
  public int numberOfOccurrences(int value) {

    int number = 0;

    for (Node current = first; current != null; current = current.getNext()) {
      if (current.getValue() == value) {
        number++;
      }
    }

    return number;
  }

  // Saber si un elemento que se pasa como parámetro está en la estructura
  public boolean contains(int value) {

    Node current = first;

    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }

    return current != null;
  }

  public void addFirst(int value) {
    // Creamos un nuevo nodo
    // la referencia first apunta a este nodo

    Node newNode = new Node(value, first);
    first = newNode;

    if (last == null) {
      last = newNode;
    }

    numOfValues++;

  }

  public void addLast(int value) {

    Node newNode = new Node(value, null);

    // Si la estructura está vacía, first apunta a newNode y last apunta a newNode
    // incrementa el número de nodos de la estructura
    if (this.isEmpty()) {
      first = newNode;
      last = newNode;
    }

    else {
      // si no está vacía, el que era last apunta a newNode y ahora newNode es last

      last.setNext(newNode);
      last = newNode;

    }
    this.numOfValues++;

  }

  public void remove(int value) {

    if (this.isEmpty()) {
      System.out.println("La estructura está vacía");
    }

    else if (this.first.hasValue(value)) {
      this.first = this.first.getNext();

      if (this.first == null) {
        this.last = null;
      }

      this.numOfValues--;
    }

    Node current = first;

    while (current.getNext() != null && !current.hasValue(value)) {
      current = current.getNext();
    }

    if (current.getNext() == null) {
      System.out.println("El valor no se encuentra en la estructura");
    }

    else {
      if (current.getNext() == last) {
        this.last = current;
        current.setNext(null);

      } else {
        current.setNext(current.getNext().getNext());

      }

      this.numOfValues--;
    }

  }

  @Override
  public String toString() {
    StringBuilder cadena = new StringBuilder();
    Node current = first;
    while (current != null) {
      cadena.append(current.getValue()).append(" ");
      current = current.getNext();
    }
    return cadena.toString().trim();
  }

}
