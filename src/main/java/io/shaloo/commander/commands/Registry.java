package io.shaloo.commander.commands;

import io.shaloo.commander.exceptions.CommandHandlerNotRegisteredException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Registry {
    private Map<Class<? extends Command>, CommandHandler> commandHandlerMap;

    public Registry() {
        this.commandHandlerMap = new HashMap<Class<? extends Command>, CommandHandler>();
    }

    @SuppressWarnings("unchecked")
    <T extends Command> CommandHandler<T> getHandler(T command) throws CommandHandlerNotRegisteredException {
        if ( !commandHandlerMap.containsKey(command.getClass()) ) {
            throw new CommandHandlerNotRegisteredException();
        }

        return (CommandHandler<T>) commandHandlerMap.get(command.getClass());
    }

    public <T extends Command> void register(Class<T> commandClass, CommandHandler<T> commandHandler) {
        if ( commandClass != null && commandHandler != null ) {
            commandHandlerMap.put(commandClass, commandHandler);
        }
        throw new IllegalArgumentException("Command class and handler are required");
    }
}
