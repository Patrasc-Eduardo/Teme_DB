package tema1.vehicles;

class A {
    void methodA() {
        class B {

        }
    }
}
public class Test {
    public static void main(String[] args) {
        BusStation busStation = new BusStation();

        busStation.getVehicles().add(new Bus("Blue", true, 16, 5.65));
        busStation.getVehicles().add(new Bus("Red", false, 20, 7.0));
        busStation.getVehicles().add(new Bus("Yellow", true, 21, 7.2));
        busStation.getVehicles().add(new Taxi("Green", true, 4, 30.0));
        busStation.getVehicles().add(new Taxi("Bright Yellow", true, 4, 65.0));

        busStation.showTotalProfit();
        busStation.showAllVehicles();
        busStation.sortVehicle();

    }
}
