package es.uvigo.esei.aed1.activity10;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class SortAlgorithms {

    // Exercise 1
    public static void bubbleSort2(int[] aux) {

        boolean noOrdenados = true;
        int fin = aux.length - 1;
        int inicio = 0;
        while ((noOrdenados) && (inicio < fin)) {

            noOrdenados = false;

            for (int i = 0; i < fin; i++) {

                if (aux[i] > aux[i + 1]) {
                    int temp = aux[i];
                    aux[i] = aux[i + 1];
                    aux[i + 1] = temp;
                    noOrdenados = true;

                }

            }

            fin--;

            for (int j = aux.length - 1; j > inicio; j--) {

                if (aux[j] > aux[j - 1]) {
                    int temp = aux[j];
                    aux[j] = aux[j - 1];
                    aux[j - 1] = temp;
                    noOrdenados = true;

                }

            }

            inicio++;

        }

    }

    // Exercise 2
    public static void shellSort(int[] aux) {
        int dist = 0;

        while (dist >= 1) {
            for (int i = 0; i < aux.length; i++) {
                int elem = aux[i];
                int j = aux[i - dist];
                while (j >= 0 && elem < aux[j]) {
                    aux[j + dist] = aux[j];
                    j = j - dist;
                }

                aux[j + dist] = elem;

            }

            dist = dist / 2;
        }

    }

    // Exercise 3
    // Produce: el dígito de número, que está en la posición pasada.
    // Para un numero de tres dígitos, pasada tomará los valores 0, 1 y 2,
    // devolviendo las unidades, decenas o centenas respectivamente.
    private static int index(int number, int iteration) {
        return (number / ((int) Math.pow(10, iteration))) % 10;
    }

    public static void radixSort(int[] numbers) {

        Queue<Integer>[] colas = new LinkedQueue[10];

        for (int i = 0; i < 10; i++) {
            colas[i] = new LinkedQueue<>();
        }

        int pasada = 0;

        while (pasada < 3) {
            for (int i = 0; i < numbers.length - 1; i++) {

                int n = index(numbers[i], pasada);

                Queue<Integer> cola = colas[n];

                cola.add(numbers[i]);

            }

            pasada++;

            for (Queue<Integer> cola : colas) {
                while (!cola.isEmpty()) {
                    cola.remove();
                }
            }

        }

    }

    // Exercise 4
    public static void selectionSort(int[] aux) {

        for (int i = 0; i < aux.length; i++) {
            
            int mayor = aux[i];

            for (int j = i+1; j < aux.length; j++) {
                if (aux[j] > aux[mayor]) {
                    mayor = j;
                }


            }

            if (mayor != i){
                int temp = aux[mayor];
                aux[mayor]=aux[i];
                aux[i] = temp;
            }

        }


    }

    // Exercise 5
    public static void countSortDec(int[] aux) {
        
        int[] nums = new int[aux.length];

        for (int i = 0; i < aux.length; i++) {
            int counter = 0;
            int mayor = i;

            for (int j = i +1; j < aux.length; j++) {
                
                if (aux[mayor] < aux[j]) {
                    counter++;
                }



            }

            nums[i] = counter;

        }


        int [] temp = new int[aux.length];

        for (int i = 0; i < aux.length; i++) {
            int pos = nums[i];
            temp[pos] = aux[i];
        }

        for (int i = 0; i < temp.length; i++) {
            aux[i]= temp[i];
        }


    }

    // Exercise 6
    public static void beadSort(int[] aux) {

    }

    // Exercise 7
    private static int searchPositionPivot(int[] aux, int beginning, int fin) {
        int first = aux[beginning];
        int k = beginning + 1;

        while (k <= fin) {
            if (aux[k] > first) {
                return k;
            } else if (aux[k] < first) {
                return beginning;
            } else {
                k++;
            }
        }
        // Si llega al final del array y todos los elementos son iguales, o si sólo hay
        // un elemento
        return -1;
    }

    private static void exchange(int[] aux, int i, int j) {
        if (i != j) {
            int temp = aux[i];
            aux[i] = aux[j];
            aux[j] = temp;
        }
    }

    private static int partition(int[] aux, int beginning, int fin, int pivot) {
        int right = beginning;
        int left = fin - 1; // pivote está en la última posición
        do {
            while (aux[right] < pivot) {
                right++;
            }
            while (aux[left] >= pivot) {
                left--;
            }
            // intercambia los valores de las posiciones derecha e izquierda
            if (right < left) {
                exchange(aux, right, left);
            }
        } while (right <= left);

        return right; // primera posición de la segunda mitad
    }

    public static void quickSort(int[] aux, int beginning, int fin) {

    }
}
