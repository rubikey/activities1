package es.uvigo.esei.aed1.activity8.wordDictionary;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class SearchList {

    private static boolean binarySearchList(List<String> listD, String word) {

        return false;
    }

    private static List<String> binaryDictionarySearch(List<WordDictionary> dictionary, String word) {

        return null;
    }

    // Exercise 8
    public static boolean dictionarySearch(List<WordDictionary> dictionary, String word) {



        char letra = word.charAt(0);

        int i = 0;
        int f = dictionary.size()-1;

        List<String> lista = null;

       
        while (i <= f) {
            int medio = (i + f) / 2;

            if (dictionary.get(medio).getLetter() > letra) {
                f = medio - 1;

            } else if (dictionary.get(medio).getLetter() < letra) {
                i = medio + 1;
            } else {

                lista = dictionary.get(medio).getWordsList();
                break;

            }

        }

        if (lista == null) {
            return false;
        }

        int inicio = 0;
        int fin = lista.size()-1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (lista.get(medio).compareTo(word) > 0) {
                fin = medio - 1;
            } else if (lista.get(medio).compareTo(word) < 0) {
                inicio = medio + 1;
            } else {
                return true;
            }

        }

        return false;
    }
}
