package tema3.observers;
import tema3.PizzaFactory;


public class OvenObserver{
    PizzaFactory pizzaFactoryObservable;

    public OvenObserver(PizzaFactory pizzaFactory) {
        this.pizzaFactoryObservable = pizzaFactory;
        this.pizzaFactoryObservable.attachObserver(this);
    }

    public void receiveUpdate() {
        System.out.println("****** New baked pizza received ********");
    }
}
