package io.shaloo.commander.exceptions;

public class CommandExecutionException extends Exception {
    private Object command;
    private Throwable cause;


    public CommandExecutionException(Object command, Throwable cause) {
        super( "Command " + command.getClass().getSimpleName() + " failed to execute: " + cause.getMessage(), cause);
        this.command = command;
        this.cause = cause;
    }

    private String getErrorMessage() {
        return "Command " + command.getClass().getSimpleName() + " failed to execute: " + cause.getMessage();
    }
}
