package io.shaloo.commander.commands;

import io.shaloo.commander.exceptions.CommandHandlerNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Translator {

    private Registry registry;

    @Autowired
    public Translator(Registry registry) {
        this.registry = registry;
    }

    <T extends Command> CommandHandler<T> toCommandHandler(T command) throws CommandHandlerNotRegisteredException {
        return this.registry.getHandler(command);
    }
}
