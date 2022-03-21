package tema1.vehicles;

import java.util.ArrayList;
import java.util.Collections;

public class BusStation {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public BusStation() {

    }

    public void showAllVehicles() {
        for(Vehicle v : vehicles) {
            v.display();
        }
    }

    public void showTotalProfit() {
        Double totalProfit = 0.0;

        for(Vehicle v : vehicles) {
            v.profit();
            totalProfit += v.getProfit();
        }

        System.out.println("Bus Station total profit:" + totalProfit);
        System.out.println();
    }

    /**
     * Sorts tema1.vehicles by profit
     */
    public void sortVehicle() {
        System.out.println("------------------------ before sort: -------------------------------------");
        vehicles.stream().forEach(v -> v.display());
        Collections.sort(vehicles);
        System.out.println("------------------------ after sort: ----------------------------------------");
        vehicles.stream().forEach(v -> v.display());
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
