package tema3.decorators;

import tema3.models.Pizza;

public abstract class ToppingDecorator implements Pizza {
    protected Pizza decoratedPizza;

    public ToppingDecorator(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public String description() {
        return decoratedPizza.description();
    }
}
