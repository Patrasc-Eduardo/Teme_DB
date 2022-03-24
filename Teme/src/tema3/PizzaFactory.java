package tema3;

import tema3.models.Marguerita;
import tema3.models.Pizza;
import tema3.models.ProsciuttoFunghi;
import tema3.models.QuattroStagioni;
import tema3.observers.OvenObserver;

import java.util.ArrayList;

public class PizzaFactory {

    private static PizzaFactory instance;
    private ArrayList<Pizza> freshlyBaked = new ArrayList<>();
    public OvenObserver ovenObserver;

    private PizzaFactory() {

    }

    public static PizzaFactory getInstance() {
        if (instance == null) {
            instance = new PizzaFactory();
        }

        return instance;
    }

    public Pizza createPizza(String type) {
        switch (type) {
            case "Marguerita":
                Marguerita marguerita = new Marguerita();
                addToFreshlyBaked(marguerita);
                return marguerita;

            case "ProsciuttoFunghi":
                ProsciuttoFunghi prosciuttoFunghi = new ProsciuttoFunghi();
                addToFreshlyBaked(prosciuttoFunghi);
                return prosciuttoFunghi;

            case "QuattroStagioni":
                QuattroStagioni quattroStagioni = new QuattroStagioni();
                addToFreshlyBaked(quattroStagioni);
                return quattroStagioni;

            default:
                System.out.println("Pizza type not found");
                break;
        }

        return null;
    }

    public void addToFreshlyBaked(Pizza pizza) {
        this.freshlyBaked.add(pizza);
        notifyObserver();
    }

    public void notifyObserver() {
        ovenObserver.receiveUpdate();
    }

    public void attachObserver(OvenObserver ovenObserver) {
        this.ovenObserver = ovenObserver;
    }

    public ArrayList<Pizza> getFreshlyBaked() {
        return freshlyBaked;
    }

    public void setFreshlyBaked(ArrayList<Pizza> freshlyBaked) {
        this.freshlyBaked = freshlyBaked;
    }
}
