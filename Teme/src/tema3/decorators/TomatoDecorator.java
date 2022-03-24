package tema3.decorators;

import tema3.models.Pizza;

public class TomatoDecorator extends ToppingDecorator {

    public TomatoDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String description() {
        return decoratedPizza.description()
                + " with"
                + " tomatoes topping";
    }
}
