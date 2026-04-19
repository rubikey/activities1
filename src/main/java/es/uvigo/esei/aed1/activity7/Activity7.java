package es.uvigo.esei.aed1.activity7;

import java.util.Iterator;

import es.uvigo.esei.aed1.activity7.hospital.Doctor;
import es.uvigo.esei.aed1.activity7.hospital.Hospital;
import es.uvigo.esei.aed1.activity7.hospital.Patient;
import es.uvigo.esei.aed1.tads.list.IteratorList;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.queue.Queue;


public class Activity7 {

  // Exercise 1
  public static List<Integer> getHigherThan(List<Integer> listToFilter, int threshold) throws NullPointerException {

    if (listToFilter == null) {
      throw new NullPointerException("Null Values");
    }

    List<Integer> result = new LinkedList<>();

    for (Integer value : listToFilter) {
      if (value > threshold) {
        result.addLast(value);
      }
    }

    return result;
  }

  // Exercise 2
  public static <T> List<T> invert(List<T> list) throws NullPointerException {

    if (list == null) {
      throw new NullPointerException("Null List");
    }

    List<T> inverted = new LinkedList<>();

    for (T element : list) {
      inverted.addFirst(element);
    }

    return inverted;
  }

  // Exercise 3
  private static <T> int countValueAppearances(List<T> list, T referenceValue) {

    int count = 0;

    for (T element : list) {
      if (element != null && element.equals(referenceValue)) {
        count++;
      } else if (element == null && referenceValue == null) {
        count++;
      }
    }

    return count;
  }

  public static <T> boolean allValuesAppearancesAreEqual(List<T> list) throws NullPointerException {

    if (list == null) {
      throw new NullPointerException("Null List");
    }

    // caso base
    if (list.isEmpty() || list.size() == 1) {
      return true;
    }

    // primer elemento
    T first = list.get(0);

    // contamos cuantas veces aparece
    int targetCount = countValueAppearances(list, first);

    // recorremos la lista, y comparamos con el primero , si no aparece el mismo
    // número de veces devuelve falso
    for (T element : list) {
      int currentCount = countValueAppearances(list, element);

      if (currentCount != targetCount) {
        return false;
      }
    }

    return true;
  }

  // Exercise 4
  public static <T extends Comparable<T>> boolean isAscendingOrder(List<T> list) throws NullPointerException {

    if (list == null) {
      throw new NullPointerException("Null List");
    }

    if (list.isEmpty()) {
      return true;
    }

    T prev = list.getFirst();

    for (T value : list) {
      if (value.compareTo(prev) < 0) {
        return false;
      }
      prev = value;
    }

    return true;
  }

  // Exercise 5
  public static <T> List<T> buildListWithRepeatedValues(List<T> list) throws NullPointerException {

    if (list == null) {
      throw new NullPointerException("Null List");
    }

    if (list.isEmpty()) {
      return new LinkedList<>();
    }

    List<T> storage = new LinkedList<>();
    List<T> seen = new LinkedList<>();

    for (T element : list) {
      if (seen.contains(element)) {
        if (!storage.contains(element)) {
          storage.addLast(element);
        }
      }

      else {
        seen.addLast(element);
      }

    }

    return storage;
  }

  // Exercise 6
  private static <T> boolean countTuplesWithAValue(List<Terna<T>> list, T value) {

    for (Terna<T> terna : list) {
      if (terna.value().equals(value)) {
        return true;
      }
    }

    return false;
  }

  public static <T> List<Terna<T>> buildSummaryList(List<T> list1, List<T> list2) throws NullPointerException {

    if (list1 == null || list2 == null) {
      throw new NullPointerException("Null List");
    }

    List<Terna<T>> summary = new LinkedList<>();

    for (T value : list1) {
      if (!countTuplesWithAValue(summary, value)) {
        int count1 = countValueAppearances(list1, value);
        int count2 = countValueAppearances(list2, value);
        summary.addLast(new Terna<>(value, count1, count2));
      }
    }

    for (T value : list2) {
      if (!countTuplesWithAValue(summary, value)) {
        int count1 = countValueAppearances(list1, value);
        int count2 = countValueAppearances(list2, value);
        summary.addLast(new Terna<>(value, count1, count2));
      }
    }

    return null;
  }

  // Exercise 7
  public static int countValuesEqualSumPreceding(List<Integer> list) throws NullPointerException {

    if (list == null) {
      throw new NullPointerException("Null List");
    }

    int suma = 0;
    int counter = 0;

    for (Integer value : list) {
      if (value == suma) {
        counter++;
      }

      suma = suma + value;

    }
    return counter;
  }

  // Exercise 8
  public static <T> List<T> printLots(List<T> list, List<Integer> index) throws NullPointerException {

    if (list == null || index == null) {
      throw new NullPointerException("Null List");
    }

    List<T> result = new LinkedList<>();

    Iterator<T> itrList = list.iterator();
    Iterator<Integer> itrIndex = index.iterator();

    int currentPos = 0; // posicion para list

    while (itrList.hasNext() && itrIndex.hasNext()) { // mientras haya valores en las listas
      int targetPos = itrIndex.next(); // cogemos como valor objetivo el valor de index, por ej 3

      while (currentPos < targetPos && itrList.hasNext()) { // ahora current pos debe avanzar hasta que sea igual al
                                                            // index, si no es. simplemente avanzamos iterador y sumamos
                                                            // a la posicion
        itrList.next();
        currentPos++;
      }

      if (currentPos == targetPos && itrList.hasNext()) { // ahora como currentPos es igual al index, añadimos al
                                                          // resultado el valor de List, y avanzamos posicion
        result.addLast(itrList.next());
        currentPos++;
      }
    }

    return result;
  }

  // Exercise 9
  public static void duplicateValues(List<Integer> list) throws NullPointerException {

    if (list == null) {
      throw new NullPointerException("Null List");
    }

    IteratorList<Integer> itrList = list.iteratorList();

    while (itrList.hasNext()) {
      Integer value = itrList.next();
      itrList.setNext(value * 2);
    }

  }

  // Exercise 10
  public static Integer getMorePatients(Hospital chuo) {

    List<Doctor> doctors = chuo.getDoctors();

    int maxPatients = -1;

    Integer bestDoctorNumber = 0;


    for (Doctor doctor : doctors) {
      Queue <Patient> q = doctor.getPatients();

      if (q.size() >= maxPatients) {
        maxPatients = q.size();
        bestDoctorNumber = doctor.getNumero();

      }
    }


    return bestDoctorNumber;
  }

  // Exercise 11
  // En este ejercicio debes implementar los métodos get y set de la clase
  // es.uvigo.esei.aed1.activity7.sparsematrix.ListNumberSparseMatrix

}
