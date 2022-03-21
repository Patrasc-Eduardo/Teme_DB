package tema1.vehicles;

public abstract class Vehicle implements Comparable<Vehicle>{

    private String color;
    private boolean functional;
    private Double profit;

    public Vehicle() {
        this.color = null;
        this.functional = false;
        this.profit = 0.0;
    }

    public Vehicle(String color, boolean functional) {
        this.color = color;
        this.functional = functional;
    }

    abstract public void charge();

    abstract public void profit();

    abstract public void display();

    @Override
    public int compareTo(Vehicle anotherVehicle) {
        return Double.compare(this.profit, anotherVehicle.profit);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
