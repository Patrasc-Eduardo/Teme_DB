package vehicles;

import java.util.ArrayList;

public class Taxi extends Vehicle {
    private int noPassengers;
    private Double ticketPrice;
    private ArrayList<Double> chargesNum = new ArrayList<>();
    //private Double totalProfit;

    public Taxi() {
        this.noPassengers = 0;
        this.ticketPrice = 0.0;
        //this.totalProfit = 0.0;
    }

    public Taxi(String color, boolean functional, int noPassengers, Double ticketPrice) {
        super(color, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void charge() {
        if (isFunctional()) {
            for (int i = 0; i < noPassengers; ++i) {
                chargesNum.add(ticketPrice);
            }
        }
    }

    @Override
    public void profit() {
        Double totalProf = 0.0;

        charge();

        for(Double price : chargesNum) {
            totalProf += (0.25) * price;
        }
        super.setProfit(totalProf);

    }

    @Override
    public void display() {
        System.out.println("\tTaxi info: \n"
                + "color: " + super.getColor() + "\n"
                + "functional? : " + super.isFunctional() + "\n"
                + "number of Passangers: " + this.noPassengers + "\n"
                + "ticket price: " + this.ticketPrice + "\n"
                + "total profit: " + super.getProfit()
                + "\n\n");
    }

    public int getNoPassengers() {
        return noPassengers;
    }

    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
