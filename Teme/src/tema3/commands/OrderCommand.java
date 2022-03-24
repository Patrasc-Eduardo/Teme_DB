package tema3.commands;

import tema3.PizzaFactory;
import tema3.models.Pizza;

public class OrderCommand extends Command {

    private final PizzaFactory factory;
    private final String typeOfPizza;

    public OrderCommand(PizzaFactory factory, String typeOfPizza) {
        this.factory = factory;
        this.typeOfPizza = typeOfPizza;
    }

    @Override
    public Pizza execute() {
        return factory.createPizza(typeOfPizza);
    }
}
