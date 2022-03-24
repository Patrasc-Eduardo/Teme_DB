package tema3.commands;

import tema3.decorators.ToppingDecorator;
import tema3.models.Pizza;

public class ToppingCommand extends Command{
    private final ToppingDecorator toppingDecorator;

    public ToppingCommand(ToppingDecorator toppingDecorator) {
        this.toppingDecorator = toppingDecorator;
    }

    @Override
    public Pizza execute() {
        System.out.println(toppingDecorator.description());
        return null;
    }
}
