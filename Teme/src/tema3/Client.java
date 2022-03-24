package tema3;

import tema3.commands.Command;
import tema3.models.Pizza;
import tema3.observers.OvenObserver;

import java.util.ArrayList;

public class Client extends Command {
    private OvenObserver ovenObserver;
    private ArrayList<Command> commandsList;

    public Client() {

    }

    public Client(OvenObserver ovenObserver) {
        this.ovenObserver = ovenObserver;
        commandsList = new ArrayList<>();
    }

    public void addToCommands(Command command) {
        this.commandsList.add(command);
    }

    @Override
    public Pizza execute() {
        commandsList.forEach(Command::execute);
        return null;
    }

}
