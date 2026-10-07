package es.uvigo.esei.aed1.activity9.airport;

public class Airport {

    private Runway[] runways;

    public Airport(int numRunways) {

        runways = new Runway[numRunways];

        for (int i = 0; i < runways.length; i++) {
            runways[i] = new Runway(i);
        }

    }

    public void assignDestinationRunway(int numRunway, String destination) {

        Runway pista = runways[numRunway];

        pista.assignDestination(destination);

    }

    public void assignFlightRunway(Flight v) {

        int menor = Integer.MAX_VALUE;
        int numeroPista = -1;

        for (int i = 0; i < runways.length; i++) {
            Runway pista = runways[i];

            if (pista.isDestination(v.getDestination())) {
                int current = pista.numberFlight();

                if (current < menor) {
                    menor = current;
                    numeroPista = i;
                }
            }

        }

        if (numeroPista != -1) {
            runways[numeroPista].assignFlight(v);
        }
    }

    public Flight takeoffFlight(int numRunway) {

        Runway pista = runways[numRunway];


        return pista.removeFlight();
    }

    public int getNumRunways() {
        return runways.length;
    }

    public int getNumAssignedFlights() {

        int total = 0;

        for (int i = 0; i < runways.length; i++) {
            total = total + runways[i].numberFlight();
        }

        return total;
    }
}
