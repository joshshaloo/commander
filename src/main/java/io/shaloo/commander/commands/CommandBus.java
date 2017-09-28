package io.shaloo.commander.commands;

import io.shaloo.commander.events.Event;
import io.shaloo.commander.events.EventDispatcher;
import io.shaloo.commander.exceptions.CommandExecutionException;
import io.shaloo.commander.exceptions.CommandHandlerNotRegisteredException;
import io.shaloo.commander.exceptions.CommandNotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandBus {

    private final Translator commandTranslator;

    private final EventDispatcher eventDispatcher;

    @Autowired
    public CommandBus(Translator commandTranslator, EventDispatcher eventDispatcher) {
        this.commandTranslator = commandTranslator;
        this.eventDispatcher = eventDispatcher;
    }

    public <T extends Command> void execute(T command) throws CommandNotImplementedException, CommandExecutionException, CommandHandlerNotRegisteredException {
        String commandName = command.getName();

        CommandHandler<T> handler = commandTranslator.toCommandHandler(command);
        handler.handle(command);
        List<Event> commandEvents = command.release();
        eventDispatcher.dispatch(commandEvents);

    }
}