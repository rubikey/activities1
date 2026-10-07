package es.uvigo.esei.aed1.activity8;

public class SearchAlgorithms {

    // Exercise 1
    public static void fillIn(int[][] aux, int xPosition, int yPosition, int newColor)
            throws IndexOutOfBoundsException {

        if (xPosition < 0 || xPosition >= aux.length || yPosition < 0 || yPosition >= aux[0].length) {
            throw new IndexOutOfBoundsException("Indexes out of bounds");
        }

        int oldColor = aux[xPosition][yPosition];

        if (newColor == oldColor) {
            return;

        }

        aux[xPosition][yPosition] = newColor;

        fillIn(aux, xPosition + 1, yPosition, newColor);
        fillIn(aux, xPosition - 1, yPosition, newColor);
        fillIn(aux, xPosition, yPosition + 1, newColor);
        fillIn(aux, xPosition, yPosition - 1, newColor);

    }

    // Exercise 2
    public static boolean isMagicSquare(int[][] board, int magicConstant) {

        if (board.length != board[0].length) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < board.length; j++) {
                sumaFila += board[i][j];

            }
            if (sumaFila != magicConstant) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            int sumaCols = 0;
            for (int j = 0; j < board.length; j++) {
                sumaCols += board[j][i];

            }
            if (sumaCols != magicConstant) {
                return false;
            }
        }

        int sumaDiagonal = 0;
        for (int i = 0; i < board.length; i++) {

            sumaDiagonal += board[i][i];

        }

        if (sumaDiagonal != magicConstant) {
            return false;
        }

        int sumaDiagSec = 0;
        for (int i = 0; i < board.length; i++) {

            sumaDiagSec += board[i][board.length - 1 - i];

        }

        if (sumaDiagSec != magicConstant) {
            return false;
        }

        return true;

    }

    // Exercise 3
    public static int howManyMinors(int[] aux, int elem) {

        int inicio = 0;
        int fin = aux.length - 1;

        int medio;

        while (inicio <= fin) {
            medio = (inicio + fin) / 2;

            if (aux[medio] > elem) {
                fin = medio - 1;
            } else if (aux[medio] < elem) {
                inicio = medio + 1;
            } else {
                return medio;
            }

        }

        return inicio;
    }

    // Exercise 4
    public static int howManyOlder(int[] aux, int elem) {

        int inicio = 0;
        int fin = aux.length - 1;

        int medio;

        while (inicio <= fin) {
            medio = (inicio + fin) / 2;

            if (aux[medio] > elem) {
                fin = medio - 1;

            } else if (aux[medio] < elem) {
                inicio = medio + 1;

            } else {
                return medio;
            }

        }

        return aux.length - fin - 1;
    }

    // Exercise 5
    public static int containNumber(int[] array, int beginning, int fin) {

        if (beginning > fin) {
            return -1;
        }

        int medio = (beginning + fin) / 2;

        if (array[medio] == medio) {
            return medio;
        } else if (array[medio] < medio) {

            return containNumber(array, medio + 1, fin);

        } else {
            return containNumber(array, beginning, medio - 1);
        }

    }

    // Exercise 6
    public static int searchInsertionDec(int[] aux, int elem, int max) {

        int inicio = 0;
        int fin = max;
        int medio;

        while (inicio <= fin) {

            medio = (inicio + fin)/2;


            if (aux[medio] > elem) {
                inicio = medio+1;

            }else if (aux[medio] < elem) {
                fin = medio - 1;

            }else{

                return medio;
            }

        }


        for (int i = max; i >= inicio; i--) {
            aux[i + 1] = aux[i];
        }

        aux[inicio] = elem;




        return inicio;

    }

}
