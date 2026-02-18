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

    for (Node current = this.first; current != null; current = current.getNext()) {
      if (current.getValue() == value) {
        number++;
      }
    }

    return number;
  }

  // Saber si un elemento que se pasa como parámetro está en la estructura
  public boolean contains(int value) {

    Node current = this.first;

    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }

    return current != null;
  }

  public void addFirst(int value) {
    // Creamos un nuevo nodo
    // la referencia first apunta a este nodo
    Node newNode = new Node(value, null);
    if (this.numOfValues == 0) {

      this.first = newNode;
      this.last = newNode;
      
    } else {

      newNode.setNext(this.first);
      this.first = newNode;
      
    }

    this.numOfValues++;

  }

  public void addLast(int value) {

    Node newNode = new Node(value, null);

    // Si la estructura está vacía, first apunta a newNode y last apunta a newNode
    // incrementa el número de nodos de la estructura
    if (this.numOfValues == 0) {
      this.first = newNode;
      this.last = newNode;
    }

    else {
      // si no está vacía, el que era last apunta a newNode y ahora newNode es last

      last.setNext(newNode);
      this.last = newNode;

    }
    this.numOfValues++;

  }

  public void remove(int value) {
// comprobar si esta vacio
    if (this.isEmpty()) {
      System.out.println("La estructura está vacía");
    }

    // comprobar si o valor que nos pasan por parametro esta na primeira posicion
    else if (this.first.hasValue(value)) {
      this.first = this.first.getNext();

      // ao elimninalo, si era o unico nodo, 
      if (this.first == null) {
        this.last = null;
      }

      this.numOfValues--;
    }

    Node current = this.first;

    while (current.getNext() != null && !current.getNext().hasValue(value)) {
      current = current.getNext();
    }

    // salimos do bucle

    // si non se encontrou
    // pode ser que sea null, que non esté
    if (current.getNext() == null) {
      System.out.println("El valor no se encuentra en la estructura");
    }

    // pode ser que esté e que sea o ultimo

    else {
      if (current.getNext() == null) {
        this.last = current;
        // current.setNext(null);

        // ou que esté polo medio
      } else {
        current.setNext(current.getNext().getNext());

      }

      this.numOfValues--;
    }

  }

  @Override
  public String toString() {
    StringBuilder cadena = new StringBuilder();
    Node current = this.first;
    while (current != null) {
      cadena.append(current.getValue()).append(" ");
      current = current.getNext();
    }
    return cadena.toString().trim();
  }

}
