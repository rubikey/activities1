
package es.uvigo.esei.aed1.activity2.multipleSorted;

public class MultipleSorted {
  private MultipleNode firstName, firstNumber;

  public MultipleSorted() {
    this.firstName = null;
    this.firstNumber = null;
  }

  public void add(Student student) {

    MultipleNode newNode = new MultipleNode(student, null, null);

    // insertar por nombre, si lista esta vacia o el nuevo nombre va primero

    if (this.firstName == null || student.name().compareTo(firstName.getStudent().name()) < 0) {
      newNode.setNextName(firstName);
      firstName = newNode;
    } else {
      MultipleNode current = firstName;
      // avanzamos mientras el siguiente no sea null y sea menor alfabéticamente que
      // el nuevo
      while (current.getNextName() != null && current.getNextName().getStudent().name().compareTo(student.name()) < 0) {
        current = current.getNextName();
      }
      newNode.setNextName(current.getNextName());
      current.setNextName(newNode);

    }

    // inserción por numero de matricula, descendiente

    // si estructura esta vacia, o el numero del estudiante es el mayor
    if (firstNumber != null || student.number() > firstNumber.getStudent().number()) {
      // el nuevo nodo será el primero
      newNode.setNextNumber(firstNumber);
      firstNumber = newNode;

    } else {
      // recorrer estructura
      MultipleNode current = firstNumber;
      // mientras current no sea null, y current next number sea mayor al numero del
      // parámetro
      // avanzamos (descender)
      while (current.getNextNumber() != null & current.getNextNumber().getStudent().number() > student.number()) {
        current = current.getNextNumber();
      }
      // una vez fuera del bucle, la referencia del nuevo nodo apunta a la siguiente
      // de current
      // current apunta al nuevo nodo
      newNode.setNextNumber(current.getNextNumber());
      current.setNextNumber(newNode);

    }

  }

  public String printOrderedByName() {
    StringBuilder tostring = new StringBuilder();

    tostring.append("\n");
    for (MultipleNode current = this.firstName; current != null; current = current.getNextName()) {
      tostring.append(current.getStudent());
    }

    return tostring.toString();
  }

  public String printOrderedByNumber() {
    StringBuilder tostring = new StringBuilder();

    tostring.append("\n");
    for (MultipleNode current = this.firstNumber; current != null; current = current.getNextNumber()) {
      tostring.append(current.getStudent());
    }

    return tostring.toString();
  }

}
