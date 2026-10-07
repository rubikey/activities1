package es.uvigo.esei.aed1.activity8.fireExtinguisher;

//Exercise 9
public class Warehouse {

    private FireExtinguisher[] warehouse;

    public Warehouse(int numFireExtinguisher) {
        int tam = (int) (numFireExtinguisher / 0.9);
        warehouse = new FireExtinguisher[tam];
    }

    private int hashFunction(int referenceNumber) {
        return referenceNumber % warehouse.length;
    }

    public boolean insertFireExtinguisher(FireExtinguisher ext) {

        int index = hashFunction(ext.getReferenceNumber());

        while(warehouse[index] != null){
            if (warehouse[index].getReferenceNumber() == ext.getReferenceNumber()) {
                return false;
            }
            index = (index + 1) % warehouse.length;
        }
        
        warehouse[index] = ext;

        return true;
    }

    public FireExtinguisher searchFireExtinguisher(int referenceNumber) {

        int index = hashFunction(referenceNumber);

        while (warehouse[index] != null) {
            if (warehouse[index].getReferenceNumber() == referenceNumber) {
                return warehouse[index];
            }
            index = (index + 1) % warehouse.length;
        }

        return null;

    }
}
