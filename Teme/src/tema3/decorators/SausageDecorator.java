package tema3.decorators;

import tema3.models.Pizza;

public class SausageDecorator extends ToppingDecorator {

    public SausageDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String description() {
        return decoratedPizza.description()
                + " with"
                + " sausages topping";
    }
}
