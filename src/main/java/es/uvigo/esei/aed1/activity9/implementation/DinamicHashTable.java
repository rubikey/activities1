package es.uvigo.esei.aed1.activity9.implementation;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class DinamicHashTable<T> implements HashTable<T> {

    private int numElems;
    private List<T>[] data;

    @SuppressWarnings("unchecked")
    public DinamicHashTable(int capacity) throws IllegalArgumentException {
        data = new List[capacity];

        for (int i = 0; i < capacity; i++) {
            data[i] = new LinkedList<>();
        }

        numElems = 0;

    }

    public DinamicHashTable() {
        this(50);
    }

    private int functionHash(T key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public boolean add(T elem) {

        int index = functionHash(elem);

        List<T> lista = data[index];

        if (lista.contains(elem)) {
            return false;
        }

        lista.addLast(elem);
        numElems++;

        return true;
    }

    @Override
    public boolean search(T elem) {
        int index = functionHash(elem);

        List<T> lista = data[index];

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(elem)) {
                T value = lista.remove(i);
                lista.add(0, value);
                return true;

            }
        }

        return false;
    }

    @Override
    public boolean remove(T elem) {

        int index = functionHash(elem); // calculamos index con la functionHash

        List<T> lista = data[index]; // accedemos a la lista con index

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(elem)) {
                lista.remove(i);
                numElems--;
                return true;

            }
        }

        return false;
    }

    @Override
    public int size() {
        int suma = 0;

        for (int i = 0; i < data.length; i++) {
            for (T val : data[i]) {
                suma = suma + 1;
            }

        }

        return suma;
    }

    @Override
    public T get() {
        

        for (int i = 0; i < data.length; i++) {
            if (!data[i].isEmpty()) {
                return data[i].get(0);
            }

        }

        return null;
    }

}
