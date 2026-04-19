
package es.uvigo.esei.aed1.activity6;

import es.uvigo.esei.aed1.activity6.implementation.CustomQueue;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Activity6 {

    // Exercise 1.1
    public static <T> void concat(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {

        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("Null queue");
        }

        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }

    }

    // Exercise 1.2
    public static <T> Queue<T> mix(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {

        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("Null queue");
        }

        Queue<T> aux = new LinkedQueue<>();

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            aux.add(queue2.remove());
            aux.add(queue1.remove());

        }

        while (!queue2.isEmpty()) {
            aux.add(queue2.remove());
        }

        while (!queue1.isEmpty()) {
            aux.add(queue1.remove());
        }

        return aux;
    }

    // Exercise 2
    public static <T> Queue<T> copy(Queue<T> queue) throws NullPointerException {

        if (queue == null)
            throw new NullPointerException("Null Queue");

        Queue<T> aux = new LinkedQueue<>();
        Queue<T> copiedQueue = new LinkedQueue<>();

        while (!queue.isEmpty()) {
            T element = queue.remove();
            aux.add(element);
        }

        while (!aux.isEmpty()) {
            T current = aux.remove();

            queue.add(current);
            copiedQueue.add(current);

        }

        return copiedQueue;
    }

    // Exercise 3
    public static Queue<Integer> mixInOrderly(Queue<Integer> queue1, Queue<Integer> queue2)
            throws NullPointerException {

        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("Null Queues");
        }

        Queue<Integer> copy1 = copy(queue1);
        Queue<Integer> copy2 = copy(queue2);

        Queue<Integer> result = new LinkedQueue<>();

        while (!copy1.isEmpty() && !copy2.isEmpty()) {
            int val1 = copy1.remove();
            int val2 = copy2.remove();

            if (val1 < val2) {
                result.add(copy1.remove());
            } else if (val1 > val2) {
                result.add(copy2.remove());
            } else {
                result.add(copy1.remove());
                copy2.remove();
            }

        }

        while (!copy1.isEmpty()) {
            result.add(copy1.remove());
        }

        while (!copy2.isEmpty()) {
            result.add(copy2.remove());
        }
        return result;
    }

    // Exercise 4
    public static <T> void moveToFront(Queue<T> queue, T value) throws NullPointerException {

        if (queue == null)
            throw new NullPointerException("Null Queue");

        Queue<T> aux = new LinkedQueue<>();
        T found = null;

        while (!queue.isEmpty()) {
            T current = queue.remove();

            if (current.equals(value)) {
                found = current;
            } else {
                aux.add(current);
            }

        }

        if (found != null) {
            queue.add(found);
        }

        while (!aux.isEmpty()) {
            queue.add(aux.remove());
        }

    }

    // Exercise 5
    public static Integer josephus(Queue<Integer> soldiers, int initialPos, int jump) {

        if (soldiers == null || soldiers.isEmpty())
            return null;

        for (int i = 0; i < initialPos; i++) {
            soldiers.add(soldiers.remove());

        }

        while (soldiers.size() > 1) {
            for (int j = 0; j < jump; j++) {
                soldiers.add(soldiers.remove());
            }
            soldiers.remove();
        }

        return soldiers.first();
    }

    // Ejercicio 6
    public static <T> boolean equalsValues(CustomQueue<T> queue) throws NullPointerException {

        if (queue == null) {
            throw new NullPointerException("Null Queue");

        }

        if (queue.isEmpty()) {
            return true; // Una cola vacía tiene todos sus elementos "iguales"
        }

        Queue<T> aux = new LinkedQueue<>();

        T first = queue.first();

        boolean areEqual = true;

        while (!queue.isEmpty()) {
            T current = queue.remove();
            aux.add(current);

            if (current == null || !current.equals(first)) {
                areEqual = false;
            }

        }

        while (!aux.isEmpty()) {
            queue.add(aux.remove());
        }

        return areEqual;
    }

}
