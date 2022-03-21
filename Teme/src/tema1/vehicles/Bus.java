package tema1.vehicles;

import java.util.ArrayList;

public class Bus extends Vehicle {
    private int noPassengers;
    private Double ticketPrice;
    private ArrayList<Double> chargesNum = new ArrayList<>();


    public Bus() {
        noPassengers = 0;
        ticketPrice = 0.0;

    }

    public Bus(String color, boolean functional, int noPassengers, Double ticketPrice) {
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

        for (Double price : chargesNum) {
            totalProf += (0.25) * price;
        }

        super.setProfit(totalProf);

    }

    @Override
    public void display() {
        System.out.println("\tBus info: \n"
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

    public ArrayList<Double> getChargesNum() {
        return chargesNum;
    }

    public void setChargesNum(ArrayList<Double> chargesNum) {
        this.chargesNum = chargesNum;
    }
}
