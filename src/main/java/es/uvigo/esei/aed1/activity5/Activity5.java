
package es.uvigo.esei.aed1.activity5;

import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;

public class Activity5 {

  // Exercise 1
  public static String reverseWords(String text) {

    Stack<Character> phrase = new LinkedStack<>();

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      if (c != ' ') {
        phrase.push(c);
      } else {
        while (!phrase.isEmpty()) {
          result.append(phrase.pop());

        }
        result.append(' ');
      }

    }

    while (!phrase.isEmpty()) {
      result.append(phrase.pop());
    }

    return result.toString();
  }

  // Exercise 2 i
  public static <T> boolean equalStacks(Stack<T> stack1, Stack<T> stack2) throws NullPointerException {

    if (stack1.isEmpty() && stack2.isEmpty()) {
      return true;
    }

    while (!stack1.isEmpty() && !stack2.isEmpty()) {
      T uno = stack1.pop();
      T dos = stack2.pop();

      if (!uno.equals(dos)) {
        return false;
      }

    }

    return true;
  }

  // Exercise 2 ii
  public static <T> Stack<T> copy(Stack<T> stack) throws NullPointerException {

    if (stack == null) {
      throw new NullPointerException("Null stack");
    }

    Stack<T> stack2 = new LinkedStack<>();
    Stack<T> aux = new LinkedStack<>();

    while (!stack.isEmpty()) {
      T element = stack.pop();
      aux.push(element);

    }

    while (!aux.isEmpty()) {
      stack2.push(aux.pop());
      stack.push(aux.pop());

    }

    return stack2;
  }

  // Exercise 3
  public static String fromBase10ToBase2(int numberBase10) {

    if (numberBase10 == 0) {
      return "0";
    }

    Stack<Integer> stack = new LinkedStack<>();
    StringBuilder result = new StringBuilder();

    while (numberBase10 > 0) {
      int resto = numberBase10 % 2;

      stack.push(resto);

      numberBase10 = numberBase10 / 2;

    }

    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }

    return result.toString();
  }

  // Exercise 4
  public static int getNumDiamonds(String sand) {

    int numDiamonds = 0;
    Stack<Character> stack = new LinkedStack<>();

    for (int i = 0; i < sand.length(); i++) {
      Character c = sand.charAt(i);

      if (c == '<') {
        stack.push(c);

      }

      else if (c == '>') {
        if (!stack.isEmpty()) {
          numDiamonds++;
          stack.pop();
        }
      }

    }

    return numDiamonds;
  }

  // Exercise 5
  public static String codifyMessage(String message) {

    Stack<Character> stack = new LinkedStack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < message.length(); i++) {
      Character c = message.charAt(i);

      // Si no es vocal, se añade a la pila
      if (!esVocal(c)) {
        stack.push(c);
      } else { // si es vocal, vaciamos la piña y construimos el string, añadimos la vocal
               // tambien
        while (!stack.isEmpty()) {
          sb.append(stack.pop());
        }
        stack.push(c);
      }

    }

    // si la frase acaba en consonante, aún pueden quedar letras en la pila, las
    // añadimos al string también
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }

  // método auxiliar para saber si es vocal
  private static boolean esVocal(char c) {

    return "aeiouAEIOU".indexOf(c) != -1;
  }

  // Exercise 6
  public static <T> T unstackAnItem(Stack<T> stack, int index) throws NullPointerException, IllegalArgumentException {

    // Si pila está null, devuelve excepción
    if (stack == null) {
      throw new NullPointerException("Null Stack");
    }

    // Si index es demasiado alto, devuelve excepción
    if (index <= 0 || index > stack.size()) {
      throw new IllegalArgumentException("Index is too high");
    }

    Stack<T> aux = new LinkedStack<>();

    for (int i = 1; i < index; i++) {
      aux.push(stack.pop());
    }

    T searchedElement = stack.pop();

    while (!aux.isEmpty()) {
      stack.push(aux.pop());
    }

    return searchedElement;
  }

  // Exercice 7
  public static boolean isWellParentized(String mathExpression) {

    Stack<Character> stack = new LinkedStack<>();

    for (int i = 0; i < mathExpression.length(); i++) {
      char c = mathExpression.charAt(i);

      if (esCaracter(c)) {
        stack.push(c);

      } else if (esCaracterCerrado(c)) {

        if (stack.isEmpty())
          return false;

        char tope = stack.pop();

        if (c == ')' && tope != '(') {
          return false;
        }
        if (c == ']' && tope != '[') {
          return false;
        }
        if (c == '}' && tope != '{') {
          return false;
        }

      }

    }

    return true;
  }

  private static boolean esCaracter(char c) {

    return "([{".indexOf(c) != -1;
  }

  private static boolean esCaracterCerrado(char c) {

    return ")]}".indexOf(c) != -1;
  }

  // Exercise 8
  public static String addDigits(int number) {

    Stack<Integer> pila = new LinkedStack<>();
    String str = Integer.toString(number);

    for (int i = str.length() - 1; i >= 0; i--) {

      pila.push(str.charAt(i) - 1);

    }

    int result = 0;

    StringBuilder sb = new StringBuilder();

    while (!pila.isEmpty()) {
      int element = pila.pop();
      sb.append(element);
      result = result + element;

      // Añadimos el " + " solo si no es el último elemento
      if (!pila.isEmpty()) {
        sb.append(" + ");
      }
    }

    sb.append(" = ").append(result);

    return sb.toString();
  }

  // Exercise 9
  public static String removeCharDuplicated(String text) {
    Stack<Character> pila = new LinkedStack<>();
    return recursiveSearch(pila, text);
  }

  private static String recursiveSearch(Stack<Character> pila, String text) {

    if (text.isEmpty()) {
      return stackToString(pila);
    }

    char c = text.charAt(0);

    if (!pila.isEmpty() && pila.top() == c) {
      pila.pop();
    } else {

      pila.push(c);
    }

    return recursiveSearch(pila, text.substring(1));
  }

  // Método auxiliar para sacar los datos de la pila en el orden correcto
  private static String stackToString(Stack<Character> stack) {
    if (stack.isEmpty()) {
      return "";
    }
    char c = stack.pop();
    // Al poner la llamada recursiva ANTES del carácter,
    // logramos que se imprima en el orden original (el fondo de la pila primero)
    return stackToString(stack) + c;
  }

  // Exercise 10
  public static <T> void replaceValues(Stack<T> stack, T newValue, T oldValue) throws NullPointerException {

    if (stack == null) {
      throw new NullPointerException("Null Stack");
    }

    Stack<T> aux = new LinkedStack<>();

    while (!stack.isEmpty()) {
      T element = stack.pop();

      if ((element == null && oldValue == null) || (element != null && element.equals(oldValue))) {
        aux.push(newValue);

      } else {
        aux.push(element);
      }
    }

    while (!aux.isEmpty()) {
      stack.push(aux.pop());
    }

  }

  // Exercise 11
  public static <T> void pushValuesLimited(Stack<T> stack, T value) throws NullPointerException {

    // Si la pila es null, lanza exception
    if (stack == null) {
      throw new NullPointerException("Null Stack");
    }

    // Pila auxiliar
    Stack<T> aux = new LinkedStack<>();

    // Tamaño maximo de pila
    int tam = 10;

    // si llegamos al tamaño maximo vaciamos la pila en aux
    if (stack.size() == tam) {

      while (!stack.isEmpty()) {
        aux.push(stack.pop());
      }

      // eliminamos el top(que viene siendo el que estuvo más tiempo en stack)
      aux.pop();

      // volcamos el resto de elementos de aux a stack
      while (!aux.isEmpty()) {
        stack.push(aux.pop());
      }

    }

    // por último añadimos el valor pasado por parámetro
    stack.push(value);

  }

}