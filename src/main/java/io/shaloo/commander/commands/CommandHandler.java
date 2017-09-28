package io.shaloo.commander.commands;

import io.shaloo.commander.events.EventDispatcher;
import io.shaloo.commander.exceptions.CommandExecutionException;
import io.shaloo.commander.exceptions.CommandNotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class CommandHandler<T extends Command> {

    @Autowired
    private Registry registry;

    @Autowired
    private EventDispatcher eventDispatcher;

    public CommandHandler() {
        registry.register(getCommandClass(), this);
    }

    public abstract void handle(T command) throws CommandNotImplementedException, CommandExecutionException;
    protected abstract Class<T> getCommandClass();

}
