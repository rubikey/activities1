package es.uvigo.esei.aed1.activity8.pellets;

public class SearchPellets {

    // Exercise 7
    public static int searchPellets(int[][] matrizCoastGalician, Position beginning, Position fin) {

        if (beginning.getX() < 0 || beginning.getX() >= matrizCoastGalician.length || beginning.getY() < 0
                || beginning.getY() >= matrizCoastGalician[0].length || fin.getX() < 0
                || fin.getX() >= matrizCoastGalician.length ||
                fin.getY() < 0 || fin.getY() >= matrizCoastGalician[0].length) {

            return -1;
        }

        int counter = 0;

        for (int i = beginning.getX(); i <= fin.getX(); i++) {
            for (int j = beginning.getY(); j <= fin.getY(); j++) {
                if (matrizCoastGalician[i][j] == 0) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
