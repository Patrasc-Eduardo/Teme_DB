package tema3;

import tema3.commands.OrderCommand;
import tema3.commands.ToppingCommand;
import tema3.decorators.TomatoDecorator;
import tema3.observers.OvenObserver;

public class Test {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = PizzaFactory.getInstance();
        OvenObserver ovenObserver = new OvenObserver(pizzaFactory);
        Client client = new Client(new OvenObserver(pizzaFactory));

        OrderCommand order1 = new OrderCommand(pizzaFactory, "Marguerita");
        OrderCommand order2 = new OrderCommand(pizzaFactory, "ProsciuttoFunghi");

        ToppingCommand topping1 = new ToppingCommand(new TomatoDecorator(pizzaFactory.createPizza("Marguerita")));

        client.addToCommands(order1);
        client.addToCommands(topping1);
        client.addToCommands(order2);

        client.execute();
    }
}
